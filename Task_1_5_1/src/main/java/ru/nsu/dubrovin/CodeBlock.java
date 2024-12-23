package ru.nsu.dubrovin;

/**
 * Class for codeblocks.
 */
public class CodeBlock extends Element {
    private String content;
    private String language;

    /**
     * Constructor.
     *
     * @param codeBlockBuilder builder.
     */
    private CodeBlock(CodeBlockBuilder codeBlockBuilder) {
        this.content = codeBlockBuilder.content;
        this.language = codeBlockBuilder.language;
    }

    /**
     * Serializes object into string.
     *
     * @return md string.
     */
    @Override
    public String toMarkDown() {
        String text = this.content;
        if (text == null) {
            throw new IllegalArgumentException("No content specified");
        }

        if (this.language == null) {
            text = "```\n" + text + "\n```";
        } else {
            text = "```" + this.language + "\n" + text + "```\n";
        }

        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static CodeBlockBuilder builder() {
        return new CodeBlockBuilder();
    }

    /**
     * Builder class.
     */
    public static class CodeBlockBuilder {
        private String content;
        private String language;

        /**
         * Sets content.
         *
         * @param content content to set.
         *
         * @return builder.
         */
        public CodeBlockBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Sets language.
         *
         * @param language language to set.
         *
         * @return builder.
         */
        public CodeBlockBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        /**
         * Building object.
         *
         * @return CodeBlock.
         */
        public CodeBlock build() {
            return new CodeBlock(this);
        }
    }

    /**
     * Equals operation for codeblocks.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CodeBlock)) {
            return false;
        }
        CodeBlock other = (CodeBlock) o;
        return (this.content == other.content) && (this.language == other.language);
    }
}
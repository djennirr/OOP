package ru.nsu.dubrovin;

public class CodeBlock extends Element {
    private String content;
    private String language;

    private CodeBlock(CodeBlockBuilder headerBuilder) {
        this.content = headerBuilder.content;
        this.language = headerBuilder.language;
    }

    @Override
    public String toMarkDown() {
        String text = this.content;
        if (text == null) {
            throw new IllegalArgumentException("No content specified");
        }
        if (this.language == null) {
            text = "```\n" + text + "\n```";
        }
        else {
            text = "```" + this.language + "\n" + text + "```\n";
        }
        return text;
    }

    public static CodeBlockBuilder builder() {
        return new CodeBlockBuilder();
    }

    public static class CodeBlockBuilder {
        private String content;
        private String language;

        public CodeBlockBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public CodeBlockBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CodeBlock)) {
            return false;
        }
        CodeBlock other = (CodeBlock) o;
        return (this.content == other.content) && (this.language == other.language);
    }
}
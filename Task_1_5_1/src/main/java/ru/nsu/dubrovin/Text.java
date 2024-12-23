package ru.nsu.dubrovin;

/**
 * Class for texts.
 */
public class Text extends Element {
    private String content;
    private boolean isItalic;
    private boolean isBold;
    private boolean isStrikeThrough;
    private boolean isCode;

    /**
     * Constructor.
     *
     * @param textBuilder builder.
     */
    private Text(TextBuilder textBuilder) {
        this.content = textBuilder.content;
        this.isItalic = textBuilder.isItalic;
        this.isBold = textBuilder.isBold;
        this.isStrikeThrough = textBuilder.isStrikeThrough;
        this.isCode = textBuilder.isCode;
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

        if (this.isCode == true) {
            text = "`" + text + "`";
        }

        if (this.isItalic == true) {
            text = "_" + text + "_";
        }

        if (this.isBold == true) {
            text = "**" + text + "**";
        }

        if (this.isStrikeThrough == true) {
            text = "~~" + text + "~~";
        }

        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static TextBuilder builder() {
        return new TextBuilder();
    }

    /**
     * Builder class.
     */
    public static class TextBuilder {
        private String content;
        private boolean isItalic;
        private boolean isBold;
        private boolean isStrikeThrough;
        private boolean isCode;

        /**
         * Sets content.
         *
         * @param content content to set.
         *
         * @return builder.
         */
        public TextBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Adds content.
         *
         * @param content content to add.
         *
         * @return builder.
         */
        public TextBuilder addContent(String content) {
            if (this.content == null) {
                this.content = content;
            }
            else {
                this.content = this.content + content;
            }
            return this;
        }

        /**
         * Sets isItalic parameter.
         *
         * @param isItalic parameter to set.
         *
         * @return builder.
         */
        public TextBuilder setItalic(boolean isItalic) {
            this.isItalic = isItalic;
            return this;
        }

        /**
         * Sets isBold parameter.
         *
         * @param isBold parameter to set.
         *
         * @return builder.
         */
        public TextBuilder setBold(boolean isBold) {
            this.isBold = isBold;
            return this;
        }

        /**
         * Sets isStrikeThrough parameter.
         *
         * @param isStrikeThrough parameter to set.
         *
         * @return builder.
         */
        public TextBuilder setStrikeThrough(boolean isStrikeThrough) {
            this.isStrikeThrough = isStrikeThrough;
            return this;
        }

        /**
         * Sets isCode parameter.
         *
         * @param isCode parameter to set.
         *
         * @return builder.
         */
        public TextBuilder setCode(boolean isCode) {
            this.isCode = isCode;
            return this;
        }

        /**
         * Building object.
         *
         * @return Text.
         */
        public Text build() {
            return new Text(this);
        }
    }

    /**
     * Equals operation for texts.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Text)) {
            return false;
        }
        Text other = (Text) o;
        return (this.content == other.content) && (this.isBold == other.isBold)
            && (this.isItalic == other.isItalic) && (this.isStrikeThrough == other.isStrikeThrough)
            && (this.isCode == other.isCode);
    }
}

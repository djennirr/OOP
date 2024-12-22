package ru.nsu.dubrovin;

public class Text extends Element {
    private String content;
    private boolean isItalic;
    private boolean isBold;
    private boolean isStrikeThrough;
    private boolean isCode;

    private Text(TextBuilder textBuilder) {
        this.content = textBuilder.content;
        this.isItalic = textBuilder.isItalic;
        this.isBold = textBuilder.isBold;
        this.isStrikeThrough = textBuilder.isStrikeThrough;
        this.isCode = textBuilder.isCode;
    }

    @Override
    public String toMarkDown() {
        String text = this.content;

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

    public static TextBuilder builder() {
        return new TextBuilder();
    }

    public static class TextBuilder {
        private String content;
        private boolean isItalic;
        private boolean isBold;
        private boolean isStrikeThrough;
        private boolean isCode;

        public TextBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public TextBuilder addContent(String content) {
            this.content = this.content + content;
            return this;
        }

        public TextBuilder setItalic(boolean isItalic) {
            this.isItalic = isItalic;
            return this;
        }

        public TextBuilder setBold(boolean isBold) {
            this.isBold = isBold;
            return this;
        }

        public TextBuilder setStrikeThrough(boolean isStrikeThrough) {
            this.isStrikeThrough = isStrikeThrough;
            return this;
        }

        public TextBuilder setCode(boolean isCode) {
            this.isCode = isCode;
            return this;
        }

        public Text build() {
            return new Text(this);
        }
    }
}

package ru.nsu.dubrovin;

public class Header extends Element{
    private String content;
    private int level;

    private Header(HeaderBuilder headerBuilder) {
        this.content = headerBuilder.content;
        this.level = headerBuilder.level;
    }

    @Override
    public String toMarkDown() {
        String text = this.content;
        text = "#".repeat(level) + " " + text;
        return text;
    }

    public static HeaderBuilder builder() {
        return new HeaderBuilder();
    }

    public static class HeaderBuilder {
        private String content;
        private int level;

        public HeaderBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public HeaderBuilder setLevel(int level) throws Exception {
            if (level < 1 || level > 6) {
                throw new Exception("Inappropriate header level");
            }
            this.level = level;
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }
}

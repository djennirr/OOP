package ru.nsu.dubrovin;

public class Header extends Element {
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

        public HeaderBuilder setLevel(int level) throws IllegalArgumentException {
            if (level < 1 || level > 6) {
                throw new IllegalArgumentException("Inappropriate header level: " + level);
            }
            this.level = level;
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Header)) {
            return false;
        }
        Header other = (Header) o;
        return (this.content == other.content) && (this.level == other.level);
    }
}

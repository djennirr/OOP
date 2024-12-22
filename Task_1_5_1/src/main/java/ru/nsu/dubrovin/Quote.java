package ru.nsu.dubrovin;

public class Quote extends Element{
    private String content;

    private Quote(QuoteBuilder quoteBuilder) {
        this.content = quoteBuilder.content;
    }

    @Override
    public String toMarkDown() {
        String text = this.content;
        text = "> " + text;
        return text;
    }

    public static QuoteBuilder builder() {
        return new QuoteBuilder();
    }

    public static class QuoteBuilder {
        private String content;
        private int level;

        public QuoteBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public Quote build() {
            return new Quote(this);
        }
    }
}

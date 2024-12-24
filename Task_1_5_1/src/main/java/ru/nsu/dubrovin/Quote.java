package ru.nsu.dubrovin;

/**
 * Class for quotes.
 */
public class Quote extends Element {
    private final String content;

    /**
     * Constructor.
     *
     * @param quoteBuilder builder.
     */
    private Quote(QuoteBuilder quoteBuilder) {
        this.content = quoteBuilder.content;
    }

    /**
     * Serializes object into string.
     *
     * @return md string.
     */
    @Override
    public String toMarkDown() {
        if (this.content == null) {
            throw new IllegalArgumentException("No content specified");
        }

        String text = "> " + this.content;
        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static QuoteBuilder builder() {
        return new QuoteBuilder();
    }

    /**
     * Builder class.
     */
    public static class QuoteBuilder {
        private String content;
        private int level;

        /**
         * Sets content.
         *
         * @param content content to set.
         *
         * @return builder.
         */
        public QuoteBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Building object.
         *
         * @return Quote.
         */
        public Quote build() {
            return new Quote(this);
        }
    }

    /**
     * Equals operation for quotes.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Quote)) {
            return false;
        }
        Quote other = (Quote) o;
        return this.content == other.content;
    }
}

package ru.nsu.dubrovin;

/**
 * Class for headers.
 */
public class Header extends Element {
    private String content;
    private int level;

    /**
     * Constructor.
     *
     * @param headerBuilder builder.
     */
    private Header(HeaderBuilder headerBuilder) {
        this.content = headerBuilder.content;
        this.level = headerBuilder.level;
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

        String text = "#".repeat(level) + " " + this.content;
        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static HeaderBuilder builder() {
        return new HeaderBuilder();
    }

    /**
     * Builder class.
     */
    public static class HeaderBuilder {
        private String content;
        private int level;

        /**
         * Sets content.
         *
         * @param content content to set.
         *
         * @return builder.
         */
        public HeaderBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Sets level parameter.
         *
         * @param level parameter to set.
         *
         * @return builder.
         */
        public HeaderBuilder setLevel(int level) throws IllegalArgumentException {
            if (level < 1 || level > 6) {
                throw new IllegalArgumentException("Inappropriate header level: " + level);
            }
            this.level = level;
            return this;
        }

        /**
         * Building object.
         *
         * @return Header.
         */
        public Header build() {
            return new Header(this);
        }
    }

    /**
     * Equals operation for headers.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Header)) {
            return false;
        }
        Header other = (Header) o;
        return (this.content == other.content) && (this.level == other.level);
    }
}

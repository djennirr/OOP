package ru.nsu.dubrovin;

/**
 * Class for links.
 */
public class Link extends Element {
    private String link;
    private String name;

    /**
     * Constructor.
     *
     * @param linkBuilder builder.
     */
    private Link(LinkBuilder linkBuilder) {
        this.link = linkBuilder.link;
        this.name = linkBuilder.name;
    }

    /**
     * Serializes object into string.
     *
     * @return md string.
     */
    @Override
    public String toMarkDown() {
        if (this.link == null) {
            throw new IllegalArgumentException("No link specified");
        }

        String text = "";
        if (this.name == null) {
            text = "[" + this.link + "]()";
        }
        else {
            text = "[" + this.name + "](" + this.link + ")";
        }

        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static LinkBuilder builder() {
        return new LinkBuilder();
    }

    /**
     * Builder class.
     */
    public static class LinkBuilder {
        private String link;
        private String name;

        /**
         * Sets link.
         *
         * @param link link to set.
         *
         * @return builder.
         */
        public LinkBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        /**
         * Sets name.
         *
         * @param name name to set.
         *
         * @return builder.
         */
        public LinkBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Building object.
         *
         * @return Link.
         */
        public Link build() {
            return new Link(this);
        }
    }

    /**
     * Equals operation for links.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Link)) {
            return false;
        }
        Link other = (Link) o;
        return (this.link == other.link) && (this.name == other.name);
    }
}

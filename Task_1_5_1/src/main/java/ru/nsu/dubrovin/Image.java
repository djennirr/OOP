package ru.nsu.dubrovin;

/**
 * Class for images.
 */
public class Image extends Element {
    private String link;
    private String altText;

    /**
     * Constructor.
     *
     * @param imageBuilder builder.
     */
    private Image(ImageBuilder imageBuilder) {
        this.link = imageBuilder.link;
        this.altText = imageBuilder.altText;
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
        if (this.altText == null) {
            text = "![](" + this.link + ")";
        } else {
            text = "![" + this.altText + "](" + this.link + ")";
        }

        return text;
    }

    /**
     * Initializing building.
     *
     * @return builder.
     */
    public static ImageBuilder builder() {
        return new ImageBuilder();
    }

    /**
     * Builder class.
     */
    public static class ImageBuilder {
        private String link;
        private String altText;

        /**
         * Sets link.
         *
         * @param link link to set.
         *
         * @return builder.
         */
        public ImageBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        /**
         * Sets altText.
         *
         * @param altText parameter to set.
         *
         * @return builder.
         */
        public ImageBuilder setAltText(String altText) {
            this.altText = altText;
            return this;
        }

        /**
         * Building object.
         *
         * @return Image.
         */
        public Image build() {
            return new Image(this);
        }
    }

    /**
     * Equals operation for images.
     *
     * @param o object to compare.
     *
     * @return whether objects are equal ore not.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        return (this.link == other.link) && (this.altText == other.altText);
    }
}

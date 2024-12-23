package ru.nsu.dubrovin;

public class Image extends Element {
    private String link;
    private String altText;

    private Image(ImageBuilder imageBuilder) {
        this.link = imageBuilder.link;
        this.altText = imageBuilder.altText;
    }

    @Override
    public String toMarkDown() {
        if (this.link == null) {
            throw new IllegalArgumentException("No link specified");
        }

        String text = "";
        if (this.altText == null) {
            text = "![](" + this.link + ")";
        }
        else {
            text = "![" + this.altText + "](" + this.link + ")";
        }

        return text;
    }

    public static ImageBuilder builder() {
        return new ImageBuilder();
    }

    public static class ImageBuilder {
        private String link;
        private String altText;

        public ImageBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        public ImageBuilder setAltText(String altText) {
            this.altText = altText;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        return (this.link == other.link) && (this.altText == other.altText);
    }
}

package ru.nsu.dubrovin;

public class Link extends Element {
    private String link;
    private String name;

    private Link(LinkBuilder linkBuilder) {
        this.link = linkBuilder.link;
        this.name = linkBuilder.name;
    }

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

    public static LinkBuilder builder() {
        return new LinkBuilder();
    }

    public static class LinkBuilder {
        private String link;
        private String name;

        public LinkBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        public LinkBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Link build() {
            return new Link(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Link)) {
            return false;
        }
        Link other = (Link) o;
        return (this.link == other.link) && (this.name == other.name);
    }
}

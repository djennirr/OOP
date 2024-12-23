package ru.nsu.dubrovin;

import java.util.ArrayList;

public class MarkDownList extends Element {
    private ArrayList<String> lines;
    private ListType listType;
    public enum ListType {
        USUAL,
        NUMERATED
    }

    private MarkDownList(MarkDownListBuilder markDownListBuilder) {
        this.lines = markDownListBuilder.lines;
        this.listType = markDownListBuilder.listType;
    }


    @Override
    public String toMarkDown() {
        String text = "";
        for (int i = 0; i < this.lines.size(); i++) {
            if (this.listType == ListType.USUAL) {
                text = text + "* ";
            }

            else if (this.listType == ListType.NUMERATED) {
                text = text + "0. ";
            }

            else {
                throw new IllegalArgumentException("No list type specified");
            }

            text = text + this.lines.get(i) + "\n";
        }
        return text;
    }

    public static MarkDownListBuilder builder() {
        return new MarkDownListBuilder();
    }

    public static class MarkDownListBuilder {
        private ArrayList<String> lines = new ArrayList<>();
        private ListType listType;


        public MarkDownListBuilder addLine(String line) {
            if (line.isEmpty()) {
                throw new IllegalArgumentException("Empty line");
            }
            this.lines.add(line);
            return this;
        }

        public MarkDownListBuilder setType(ListType listType) {
            this.listType = listType;
            return this;
        }

        public MarkDownList build() {
            return new MarkDownList(this);
        }
    }
}

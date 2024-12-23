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

        if (this.lines.isEmpty()) {
            throw new IllegalArgumentException("No lines specified");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.lines.size(); i++) {
            if (this.listType == ListType.USUAL) {
                stringBuilder.append("* ");
            }

            else if (this.listType == ListType.NUMERATED) {
                stringBuilder.append("0. ");
            }

            else {
                throw new IllegalArgumentException("No list type specified");
            }

            String line = this.lines.get(i);
            if (line == null) {
                throw new IllegalArgumentException("No content specified on line " + i);
            }

            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MarkDownList)) {
            return false;
        }
        MarkDownList other = (MarkDownList) o;

        boolean linesCompare = true;
        for (int i = 0; i < this.lines.size(); i++) {
            String line1 = this.lines.get(i);
            String line2 = this.lines.get(i);

            if (line1 == null) {

                if (line2 != null) {
                    linesCompare = false;
                    break;
                }

                else {
                    break;
                }
            }

            else {

                if (line1 != line2) {
                    linesCompare = false;
                    break;
                }
            }
        }

        return linesCompare && (this.listType == other.listType);
    }
}

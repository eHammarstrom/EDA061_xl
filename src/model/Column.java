package model;

public class Column {
    private char col;

    public Column(char col) {
        this.col = col;
    }

    public String toString() {
        return Character.toString(col);
    }
}

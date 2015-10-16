package model;

public class Address {
    private Column col;
    private Row row;

    public Address(Column col, Row row) {
        this.col = col;
        this.row = row;
    }

    public Address(String addr) {
        this.col = new Column(addr.charAt(0));
        this.row = new Row(Integer.parseInt(addr.substring(1)));
    }

    public String toString() {
        return col.toString() + row.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address)
            if (toString().equals(obj.toString()))
                return true;
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

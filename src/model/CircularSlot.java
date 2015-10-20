package model;

import expr.Environment;
import util.XLException;

public class CircularSlot implements Slot {

    public String toString() {
        throw new XLException("Circular Error");
    }

    @Override
    public double getValue(Environment e) {
        throw new XLException("Circular Error");
    }

}

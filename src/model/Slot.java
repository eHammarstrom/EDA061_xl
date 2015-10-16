package model;


import expr.Environment;

public interface Slot {

    String toString();

    double getValue(Environment e);
}

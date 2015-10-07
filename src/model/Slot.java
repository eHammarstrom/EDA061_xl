package model;


import expr.Environment;

public interface Slot {
	
	public String toString();
	
	public double getValue(Environment e);
}

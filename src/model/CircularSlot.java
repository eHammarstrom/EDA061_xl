package model;

import expr.Environment;
import util.XLException;

public class CircularSlot implements Slot {
	
	// This slot handles errors
	
	public String toString() {	
		throw new XLException("ERROR BIATCH (CIRCULAR)");
	}

	@Override
	public double getValue(Environment e) {
		throw new XLException("ERROR BIATCH (CIRCULAR)");
	}
	
	
	
}

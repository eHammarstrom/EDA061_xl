package model;

import expr.*;

import expr.Environment;

public class ExpressionSlot implements Slot {
	private Expr expr;
	
	public ExpressionSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double getValue(Environment e) {
		return expr.value(e);
	}
	
	@Override
	public String toString() {
		return expr.toString();
	}
}

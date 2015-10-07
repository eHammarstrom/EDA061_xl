package model;

import java.beans.Expression;

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
}

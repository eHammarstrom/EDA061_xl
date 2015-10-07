package model;


import expr.Environment;

public class CommentSlot implements Slot {
	private String comment;
	
	public CommentSlot(String comment) {
		this.comment = comment;
	}

	@Override
	public double getValue(Environment e) {
		return 0;
	}
	
	@Override
	public String toString() {
		return comment;
	}
}

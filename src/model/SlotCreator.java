package model;

import expr.ExprParser;

public class SlotCreator {
	
	public Slot createSlot(String input) {
		
		ExprParser parser = new ExprParser();
		
		try {
			if(input.charAt(0) == '#') {
				return new CommentSlot(input);
			} else {
				return new ExpressionSlot(parser.build(input));
			}
		} catch (Exception error) {
			return new CircularSlot();
		}
		
	}

}

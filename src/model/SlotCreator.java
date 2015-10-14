package model;

import expr.ExprParser;
import util.XLException;

public class SlotCreator {
	
	public Slot createSlot(String input) {
		
		ExprParser parser = new ExprParser();
		
		if(input.charAt(0) == '#') {
			return new CommentSlot(input.substring(1));
		} else {
			try {
				System.out.println("Expression built by SlotCreator for Editor: " + input);
				return new ExpressionSlot(parser.build(input));
			} catch (Exception error) {
				throw new XLException("SlotCreator failure");
			}
		}
		
	}

}

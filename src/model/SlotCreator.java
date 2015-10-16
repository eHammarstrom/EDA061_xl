package model;

import expr.ExprParser;
import util.XLException;

public class SlotCreator {

    public Slot createSlot(String input) {

        ExprParser parser = new ExprParser();

        if (input.charAt(0) == '#') {
            System.out.println("Comment");
            return new CommentSlot(input);
        } else {
            try {
                System.out.println("Expression built by SlotCreator for Editor: " + input);
                return new ExpressionSlot(parser.build(input));
            } catch (Exception e) {
                throw new XLException("SlotCreator failure");
            }
        }

    }

}

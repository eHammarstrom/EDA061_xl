package gui;

import javax.swing.*;
import java.awt.*;

public class ColoredLabel extends JLabel {
    public ColoredLabel(String text) {
        this(text, Color.WHITE, SwingConstants.LEFT);
    }

    public ColoredLabel(String text, Color color) {
        this(text, color, SwingConstants.LEFT);
    }

    public ColoredLabel(String text, Color color, int alignment) {
        super(text, alignment);
        setBackground(color);
        setOpaque(true);
    }
}

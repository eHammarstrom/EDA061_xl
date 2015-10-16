package gui;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    public GridPanel(int rows, int columns) {
        super(new GridLayout(rows, columns, 2, 2));
        setBackground(Color.BLACK);
    }
}

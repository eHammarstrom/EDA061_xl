package gui;

import model.Sheet;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        SlotLabels slotLabels = new SlotLabels(rows, columns, cs, sl, sheet);
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, cs, sl, sheet));
    }
}

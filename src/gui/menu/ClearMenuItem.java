package gui.menu;

import gui.CurrentSlot;
import model.Sheet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private Sheet sheet;
    private CurrentSlot cs;

    public ClearMenuItem(Sheet sheet, CurrentSlot cs) {
        super("Clear");
        addActionListener(this);
        this.sheet = sheet;
        this.cs = cs;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.removeSlot(cs.getAddress());
    }
}

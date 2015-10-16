package gui.menu;

import model.Sheet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private Sheet sheet;

    public ClearAllMenuItem(Sheet sheet) {
        super("Clear all");
        addActionListener(this);
        this.sheet = sheet;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearSheet();
    }
}

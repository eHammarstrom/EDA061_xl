package gui.menu;

import gui.XL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewMenuItem extends JMenuItem implements ActionListener {
    private XL xl;

    public NewMenuItem(XL xl) {
        super("New");
        this.xl = xl;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        new XL(xl);
    }
}

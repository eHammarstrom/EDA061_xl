package gui;

import model.Address;
import model.Sheet;
import util.XLException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Editor extends JTextField implements Observer, ActionListener {
    Sheet sheet;
    StatusLabel sl;
    CurrentSlot cs;

    public Editor(CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        this.sl = sl;
        this.cs = cs;
        addActionListener(this);
        cs.addObserver(this);
        sheet.addObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //sl.clear();
        Address addr = cs.getAddress();

        if (getText().isEmpty()) {
            try {
                sheet.removeSlot(addr);
            } catch (XLException error) {
                sl.setText(error.getMessage());
            }
        } else {
            try {
                sheet.setSlot(addr, getText());
            } catch (XLException error) {
                sl.setText(error.getMessage());
            }
        }

        sheet.notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        System.out.println("Editor tried to update: " + cs.getAddress().toString());

        setText(sheet.getExpressionSlotTextToString(cs.getAddress()));
    }
}

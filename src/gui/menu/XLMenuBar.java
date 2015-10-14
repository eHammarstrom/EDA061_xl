package gui.menu;

import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import model.Sheet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Sheet sheet) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel, sheet));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem());
        edit.add(new ClearAllMenuItem());
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}
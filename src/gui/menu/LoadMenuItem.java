package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;

import javax.swing.*;
import java.io.FileNotFoundException;

class LoadMenuItem extends OpenMenuItem {
    private Sheet sheet;

    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.load(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}

package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;

import javax.swing.*;
import java.io.FileNotFoundException;

class SaveMenuItem extends OpenMenuItem {
    private Sheet sheet;

    public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.save(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}

package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
	private Sheet sheet;
	
    public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        XLPrintStream print = new XLPrintStream(path);
        print.save(sheet.getEntries());
        print.flush();
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}
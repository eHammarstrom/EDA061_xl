package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
    	XLBufferedReader xlbr = new XLBufferedReader(path);
    	sheet.clearSheet();
    	xlbr.load(sheet.getSheet());
    	sheet.notifyObservers();
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
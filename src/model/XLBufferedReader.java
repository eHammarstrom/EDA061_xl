package model;

import util.XLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Sheet sheet) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');

                sheet.setSlot(new Address(string.substring(0, i)), string.substring(i + 1));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}

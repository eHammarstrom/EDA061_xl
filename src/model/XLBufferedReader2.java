package model;

import util.XLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

//TODO move to another package
public class XLBufferedReader2 extends BufferedReader {
    public XLBufferedReader2(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<Address, Slot> map) {
        try {
            SlotCreator slotCreator = new SlotCreator();

            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');

                map.put(new Address(string.substring(0, i)),
                        slotCreator.createSlot(string.substring(i + 1)));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}

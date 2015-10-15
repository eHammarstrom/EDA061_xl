package gui.menu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Set;

import model.Address;
import model.Slot;

//TODO move to another package
public class XLPrintStream extends PrintStream {
    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    // TODO Change Object to something appropriate
    public void save(Set<Entry<Address, Slot>> set) {
        for (Entry<Address, Slot> entry : set) {
            print(entry.getKey().toString());
            print('=');
            println(entry.getValue().toString());
        }
        flush();
        close();
    }
}

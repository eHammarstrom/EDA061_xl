package gui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
    private CurrentSlot cs;


    public CurrentLabel(CurrentSlot cs) {
        super("A1", Color.WHITE);
        this.cs = cs;
        cs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        setText(cs.getAddress().toString());
    }


}

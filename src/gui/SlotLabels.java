package gui;

import model.Address;
import model.Column;
import model.Row;
import model.Sheet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private Sheet sheet;
    private CurrentSlot cs;


    public SlotLabels(int rows, int cols, CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        this.sheet = sheet;
        this.cs = cs;


        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }

        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {

                Address addr = new Address(new Column(ch), new Row(row));

                SlotLabel label = new SlotLabel(addr, cs);
                add(label);
                labelList.add(label);
            }
        }

        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        cs.set(firstLabel);
        cs.addObserver(this);
        sheet.addObserver(this);

    }


    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

        for (SlotLabel sl : labelList) {
            sl.setText(sheet.getSlotValueToString(sl.getAddress()));
            sl.setBackground(Color.WHITE);
            if (sl.getAddress().equals(cs.getAddress())) {
                sl.setBackground(Color.YELLOW);
            }


        }
    }
}



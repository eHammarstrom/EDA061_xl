package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import model.Address;
import model.Column;
import model.Row;
import model.Sheet;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;
    private Sheet sheet;
    private StatusLabel sl;


    public SlotLabels(int rows, int cols, CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);        
        this.sheet = sheet;
        this.sl = sl;
        
        
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                
            	Address addr = new Address(new Column(ch), new Row(row));
            	
                SlotLabel label = new SlotLabel(addr, cs, sl, sheet);
               // cs.addObserver(label);
                add(label);
                labelList.add(label);
            }
        }
        
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        cs.set(firstLabel);

    }
}



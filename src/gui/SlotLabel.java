package gui;

import model.Address;
import model.Sheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabel extends ColoredLabel implements MouseListener {
    private Address addr;
    private CurrentSlot cs;


    public SlotLabel(Address addr, CurrentSlot cs) {
        super("                    ", Color.WHITE, RIGHT);
        this.addr = addr;
        this.cs = cs;
        addMouseListener(this);
    }

    public Address getAddress() {
        return addr;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cs.set(this);
        cs.notifyObservers();
        setBackground(Color.YELLOW);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }


}

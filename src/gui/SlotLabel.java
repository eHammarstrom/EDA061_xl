package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Address;
import model.Sheet;
import util.XLException;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	private Address addr;
	private CurrentSlot cs;
	private StatusLabel sl;
	private Sheet sheet;
	
	
    public SlotLabel(Address addr, CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
        this.addr = addr;
        this.cs = cs;
        this.sl = sl;
        this.sheet = sheet;
        addMouseListener(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		setText(sheet.getSlotValueToString(addr));
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
		System.out.println("Observers: " + cs.countObservers());
		sl.clear();
		cs.setWhite();
		cs.set(this);
		setBackground(Color.YELLOW);
		
		System.out.println("Mouse Pressed");
		
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
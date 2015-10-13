package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Address;
import model.Sheet;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	Address addr;
	CurrentSlot cs;
	StatusLabel sl;
	Sheet sheet;
	
	
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
		// TODO Auto-generated method stub
		
		Address addr = cs.getAddress();
		String data = sheet.getSlotString(addr);
		setText(data);
		
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
		cs.setWhite();
		setBackground(Color.YELLOW);
		cs.set(this);
		cs.notifyObservers();
		sl.clear();
		
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
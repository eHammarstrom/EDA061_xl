package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	CurrentSlot cs;
	StatusLabel sl;
	Sheet sheet;
	
	
    public SlotLabel(CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
        this.cs = cs;
        this.sl = sl;
        this.sheet = sheet;
        addMouseListener(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
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
		
		System.out.println("Click!");
		
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
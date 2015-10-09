package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;


public class Editor extends JTextField implements Observer, ActionListener {
	Sheet sheet;
	StatusLabel sl;
	CurrentSlot cs;
	
	
    public Editor(CurrentSlot cs, StatusLabel sl, Sheet sheet) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        this.sl = sl;
        this.cs = cs;
        addActionListener(this);
        cs.addObserver(this);
        
    }
    
    public Editor() {
        setBackground(Color.WHITE);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Click!");
	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	
		String name = cs.getName();

	}
}
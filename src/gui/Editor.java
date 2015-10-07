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
	
	
//    public Editor(Sheet sheet, StatusLabel sl, CurrentSlot cs) {
//        setBackground(Color.WHITE);
//        this.sheet = sheet;
//        this.sl = sl;
//        this.cs = cs;
//        addActionListener(this);
//        
//    }
    
    public Editor() {
        setBackground(Color.WHITE);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
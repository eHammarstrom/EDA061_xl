package model;

import java.util.HashMap;
import java.util.Observable;

import gui.CurrentSlot;
import util.XLException;

public class Sheet extends Observable implements expr.Environment {
	private HashMap<Address, Slot> sheet;
	private SlotCreator slotCreator;
	private CurrentSlot cs;
	
	public Sheet(CurrentSlot cs) {
		sheet = new HashMap<Address, Slot>();
		slotCreator = new SlotCreator();		
		this.cs = cs;
	}
	
	public HashMap<Address, Slot> getSheet() {
		return sheet;
	}
	
	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
	
//	public Slot getSlot(Address address) {
//		return sheet.get(address);
//	}

	public void setSlot(Address address, String input) {
//		System.out.println("sheet.setSlot: Trying to slotCreator.createSlot(" + input + ")");
		Slot slot = slotCreator.createSlot(input);
//		System.out.println("sheet.setSlot: Successfully built the slot.\n" + 
//				"Checking circularCheck");
		circularCheck(address, slot);
//		System.out.println("Passed circularCheck\n" + 
//				"sheet.setSlot(" + address + ", " + input + ")");
		sheet.put(address, slot);
//		System.out.println("sheet.setSlot: Successfully sheet.put(" + address + ", " + input + ")");
		cs.notifyObservers();
	}
	
	public void removeSlot(Address address) {
		sheet.remove(address);
	}
	
	public void circularCheck(Address address, Slot slot) {
		Slot oldSlot = sheet.get(address);
		CircularSlot errorSlot = new CircularSlot();
		sheet.put(address, errorSlot);
		try {
			slot.getValue(this);
		} finally {
			sheet.put(address, oldSlot);
		}

	}
	
	public void clearSheet() {
		sheet.clear();
		notifyObservers();
	}
	
	@Override
	public double value(String name) {
		Slot slot = sheet.get(new Address(name));
		
		if (slot == null) 
			throw new XLException("Null Slot");
		
		System.out.println("sheet.value: slot was not null - " + slot.toString());

		return slot.getValue(this);	
	}
	
	public String getSlotValueToString(Address address) {
		try {
			Slot slot = sheet.get(address);
		
			if (slot instanceof CommentSlot)
				return getCommentToString(address);
			else
				return Double.toString(slot.getValue(this));
		} catch (Exception xle) {
			return getExpressionSlotTextToString(address);
		}
	}
	
	private String getCommentToString(Address address) {
		String commentSlot = sheet.get(address).toString().substring(1);
		if (commentSlot == null)
			return "";
		
		return commentSlot;
	}
	
	private String getExpressionSlotTextToString(Address address) {
		if (sheet.get(address) == null) {
			return "";
		}

		return sheet.get(address).toString();
	}

}

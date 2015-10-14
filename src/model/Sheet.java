package model;

import java.util.HashMap;

import gui.CurrentSlot;
import util.XLException;

public class Sheet implements expr.Environment {
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
	
	public void updateSheet(Sheet s) {
		cs.notifyObservers();
	}
	
	public Slot getSlot(Address address) {
		return sheet.get(address);
	}

	public void setSlot(Address address, String input) {
		System.out.println("sheet.setSlot: Trying to slotCreator.createSlot(" + input + ")");
		Slot slot = slotCreator.createSlot(input);
		System.out.println("sheet.setSlot: Successfully built the slot.\n" + 
				"Checking circularCheck");
		circularCheck(address, slot);
		System.out.println("Passed circularCheck\n" + 
				"sheet.setSlot(" + address + ", " + input + ")");
		sheet.put(address, slot);
		System.out.println("sheet.setSlot: Successfully sheet.put(" + address + ", " + input + ")");
		updateSheet(this);
	}
	
	public void removeSlot(Address address) {
		sheet.remove(address);
	}
	
	public void circularCheck(Address address, Slot slot) {
		CircularSlot circularSlot = new CircularSlot();
		sheet.put(address, circularSlot);
		try {
//			 currentSlot.getValue(this); // "finally" always executes, even though this might return an exception
		} finally {
			sheet.put(address, slot);
		}
	}
	
	public void clearSheet() {
		sheet.clear();
		updateSheet(this);
	}
	
	@Override
	public double value(String name) {
		
		Slot slot = sheet.get(new Address(name));
		
		if(slot == null) {
			throw new XLException("Empty slot");
		}

		return slot.getValue(this);	
	}
	
	public String getSlotString(Address address) {
		if (getSlot(address) == null) {
			return "";
		}
		return getSlot(address).toString();
	}

}

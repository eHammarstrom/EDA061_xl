package model;

import java.util.HashMap;


import util.XLException;

public class Sheet implements expr.Environment{
	HashMap<Address, Slot> sheet;
	
	public Sheet(Address adress, Slot slot) {
		sheet = new HashMap<Address, Slot>();
	}
	
	public HashMap<Address, Slot> getSheet() {
		return sheet;
	}
	
	public void updateSheet(Sheet s) {
		sheet = s.sheet;
	}
	
	public Slot getSlot(Address address) {
		return sheet.get(address);
	}
	
	public void setSlot(Address address, Slot slot) {
		sheet.put(address, slot);
	}
	
	@Override
	public double value(String name) {
		Slot slot = sheet.get(new Address(name));
		
		if(slot == null) {
			throw new XLException("Empty slot");
		}

		return slot.getValue(this);	
	}

}

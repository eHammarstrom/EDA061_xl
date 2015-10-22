package model;

import util.XLException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;

public class Sheet extends Observable implements expr.Environment {
	private HashMap<Address, Slot> sheet;
	private SlotCreator slotCreator;

	public Sheet() {
		sheet = new HashMap<Address, Slot>();
		slotCreator = new SlotCreator();
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

	public void setSlot(Address address, String input) {
		try {
			Slot slot = slotCreator.createSlot(input);
			circularCheck(address, slot);
			sheet.put(address, slot);
			notifyObservers();
		} catch (XLException e) {
			throw new XLException(e.getMessage());
		}

	}

	public void removeSlot(Address address) {
		for (Address addr : sheet.keySet()) {
			if (getExpressionSlotTextToString(addr).contains(address.toString())) {
				System.out.println(getExpressionSlotTextToString(addr));
				System.out.println(address.toString());
				return;
			}
		}

		sheet.remove(address);
		notifyObservers();
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

	public String getExpressionSlotTextToString(Address address) {
		if (sheet.get(address) == null) {
			return "";
		}

		return sheet.get(address).toString();
	}

	public void load(String path) throws FileNotFoundException {
		sheet.clear();
		XLBufferedReader2 XL = new XLBufferedReader2(path);
		XL.load(sheet);
		notifyObservers();
	}

	public void save(String path) throws FileNotFoundException {
		XLPrintStream XL = new XLPrintStream(path);
		XL.save(sheet.entrySet());
	}
}

package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentSlot extends Observable {
	private SlotLabel csLabel;

	public CurrentSlot() {
	}

	public String getName() {
		return csLabel.getName();
	}

	public void set(SlotLabel slotLabel) {
		csLabel = slotLabel;
		notifyObservers();
		addObserver(slotLabel);
	}

	public void setWhite() {
		csLabel.setBackground(Color.WHITE);
	}

}

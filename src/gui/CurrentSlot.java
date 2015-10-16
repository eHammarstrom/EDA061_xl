package gui;

import model.Address;

import java.util.Observable;

public class CurrentSlot extends Observable {
    //	private SlotLabel csLabel;
    private Address address;

    public CurrentSlot() {

    }

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    //	public String getName() {
    //		return csLabel.getAddress().toString();
    //	}

    public Address getAddress() {
        return address;
    }

    public void set(SlotLabel slotLabel) {
        // csLabel = slotLabel;
        address = slotLabel.getAddress();
        //	addObserver(slotLabel);
        notifyObservers();
    }

    //	public void setWhite() {
    //		csLabel.setBackground(Color.WHITE);
    //	}

}

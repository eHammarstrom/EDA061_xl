package gui;

import model.Address;

import java.util.Observable;

public class CurrentSlot extends Observable {
    private Address address;

    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

    public Address getAddress() {
        return address;
    }

    public void set(SlotLabel slotLabel) {
        address = slotLabel.getAddress();
        notifyObservers();
    }

}

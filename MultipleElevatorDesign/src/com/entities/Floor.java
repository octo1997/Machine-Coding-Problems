package com.entities;

public class Floor {
    private final int floorNo;
    private final Door door;
    private final ButtonPanel buttonPanel;

    public Floor(int floorNo, Door door, ButtonPanel buttonPanel) {
        this.floorNo = floorNo;
        this.door = door;
        this.buttonPanel = buttonPanel;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public Door getDoor() {
        return door;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public int callCar(Direction dir){
        return buttonPanel.callDispatcher(new ElevatorEvent(floorNo, null, dir));
    }
}

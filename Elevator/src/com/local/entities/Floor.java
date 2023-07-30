package com.local.entities;

import com.local.entities.buttons.ButtonPanel;

public class Floor {
    private ButtonPanel buttonPanel;
    private int floorNo;

    public Floor(ButtonPanel buttonPanel, int floorNo) {
        this.buttonPanel = buttonPanel;
        this.floorNo = floorNo;
    }

    public void sendDispatcherSignal(Direction direction){
        buttonPanel.sendSignalToDispatcher(floorNo, direction);
    }
}

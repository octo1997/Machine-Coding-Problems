package com.local.entities.buttons;

import com.local.entities.Direction;
import com.local.services.DispatcherService;

public class ButtonPanel {
    public void sendSignalToDispatcher(int destinationFloor, Direction direction){
        DispatcherService.getInstance().receiveSignal(destinationFloor, direction);
    }
}

package com.entities;

import com.services.DispatcherService;

public class FloorButtonPanel implements ButtonPanel{
    @Override
    public int callDispatcher(ElevatorEvent elevatorEvent) {
        try {
            return DispatcherService.getInstance().callToFloor(elevatorEvent);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

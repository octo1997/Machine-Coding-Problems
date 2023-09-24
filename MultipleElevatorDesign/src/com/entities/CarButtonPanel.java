package com.entities;

import com.services.DispatcherService;

public class CarButtonPanel implements ButtonPanel{
    @Override
    public int callDispatcher(ElevatorEvent elevatorEvent) {
        try {
            DispatcherService.getInstance().goToFloor(elevatorEvent);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}

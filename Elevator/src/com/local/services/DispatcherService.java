package com.local.services;

import com.local.entities.Car;
import com.local.entities.Direction;

import java.util.List;


public class DispatcherService {
    private static DispatcherService instance = new DispatcherService();

    private DispatcherService() {
    }

    public static DispatcherService getInstance() {
        return instance;
    }

    public void receiveSignal(int destinationFloor, Direction direction){
        LiftManager liftManager = LiftManager.getInstance();

        List<Car> cars = liftManager.getCars();
        for(Car car: cars){
            if(car.getDirection().equals(direction)){
                if(direction.equals(Direction.UP) && car.getCurrentFloor() <= destinationFloor){
                    car.addDestinitionAndStartLift(destinationFloor);
                    return;
                }
            }
        }

        //wait till any car gets idle i.e its direction is neutral

    }
}

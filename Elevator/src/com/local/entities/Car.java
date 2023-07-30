package com.local.entities;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private int carId, currentFloor, destinitionFloor;
    private Direction direction = Direction.NUETRAL;
    private final Map<Integer, Boolean> floorStatus = new HashMap<Integer, Boolean>();
    public Car(int carId, int currentFloor, int destinitionFloor) {
        this.carId = carId;
        this.currentFloor = currentFloor;
        this.destinitionFloor = destinitionFloor;
    }

    public void dispatchInternalSignal(int destinitionFloor){
        addDestinitionAndStartLift(destinitionFloor);
    }

    public synchronized void addDestinitionAndStartLift(int floor){
        floorStatus.put(floor, true);
        startLift();
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinitionFloor() {
        return destinitionFloor;
    }

    public void setDestinitionFloor(int destinitionFloor) {
        this.destinitionFloor = destinitionFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Map<Integer, Boolean> getFloorStatus() {
        return floorStatus;
    }
}

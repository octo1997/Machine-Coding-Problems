package com.services;

import com.entities.Building;
import com.entities.Car;
import com.entities.Direction;
import com.entities.ElevatorEvent;

import static com.entities.Direction.DOWN;
import static com.entities.Direction.UP;

public class DispatcherService {
    private Building building;
    private DispatcherService() {}
    private static DispatcherService instance = new DispatcherService();
    public static DispatcherService getInstance() {
        return instance;
    }

    public void setBuilding(Building building){
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public void goToFloor(ElevatorEvent elevatorEvent) throws InterruptedException {
        int carNo = elevatorEvent.carNo();
        int destFloor = elevatorEvent.floorNo();

        Car car = building.getCars().get(carNo);
//        building.getFloors().get(car.getCurrentFloor()).getDoor().close();
        car.addStop(destFloor);
        car.startCar();
    }

    public int callToFloor(ElevatorEvent elevatorEvent) throws InterruptedException {
        int floor = elevatorEvent.floorNo();
        Direction dir = elevatorEvent.direction();
        for (Car car: building.getCars()){
            if(isValid(car, floor, dir)){
                car.addStop(floor);
                car.startCar();

                return car.getCarNo();
            }
        }
        while(true){
            Thread.sleep(101);
            callToFloor(elevatorEvent);
        }

    }

    private boolean isValid(Car car, int floor, Direction dir){

        return switch (car.getDirection()){
            case NEUTRAL -> true;
            case UP -> (floor <= car.getCurrentFloor() && dir.equals(UP));
            case DOWN -> (floor >= car.getCurrentFloor() && dir.equals(DOWN));
        };
    }
}

package com.entities;

import java.util.ArrayList;
import java.util.List;

import static com.entities.Direction.*;

public class Car {
    private static final int time = 2000;
    private int capacity = 1000;
    private int currentFloor = 0;
    private int carNo;
    private final List<Boolean> floorArr = new ArrayList();
    private final ButtonPanel buttonPanel;
    private Direction direction = Direction.NEUTRAL;

    public Car(ButtonPanel buttonPanel, int carNo, int floorNo) {
        this.buttonPanel = buttonPanel;
        this.carNo = carNo;
        init(floorNo);
    }

    private void init(int floorNo){
        for(int i = 0; i < floorNo; i++) floorArr.add(false);
    }

    public int getCarNo() {
        return carNo;
    }

    public synchronized void startCar() throws InterruptedException {
        System.out.println(floorArr);
        if(direction.equals(NEUTRAL)){

            int high = getNextHigh();
            int low = getNextLow();
            while (high != currentFloor || low != currentFloor){
                if(high != currentFloor){
                    direction = UP;
                    while (getNextHigh() != currentFloor){
                        currentFloor++;
                        Thread.currentThread().sleep(time);
                        if(floorArr.get(currentFloor)){
                            System.out.println("Car " + carNo + " stopped at floor " + currentFloor);
                            floorArr.set(currentFloor, false);
                        }else{
//                            System.out.println("Car " + carNo + " sweeped floor " + currentFloor);
                        }
                    }
                    direction = NEUTRAL;
                }
                low = getNextLow();
                if(low != currentFloor){
                    direction = DOWN;
                    while (getNextLow() != currentFloor){
                        currentFloor--;
                        Thread.currentThread().sleep(time);
                        if(floorArr.get(currentFloor)){
                            System.out.println("Car " + carNo + " Stopped at floor " + currentFloor);
                            floorArr.set(currentFloor, false);
                        }else{
//                            System.out.println("Car " + carNo + " sweeped floor " + currentFloor);
                        }
                    }
                    direction = NEUTRAL;
                }
                high = getNextHigh();
                low = getNextLow();
            }

        }
    }

    public int getNextLow(){
        int low = currentFloor;
        for(int i = currentFloor; i >= 0; i--){
            if(floorArr.get(i)){
                low = i;
                break;
            }
        }
        return low;
    }
    public int getNextHigh(){
        int high = currentFloor;
        for(int i = currentFloor; i < floorArr.size(); i++){
            if(floorArr.get(i)){
                high = i;
                break;
            }
        }
        return high;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void addStop(int floorNo){
        if(floorNo < floorArr.size()){
            floorArr.set(floorNo, true);
        }
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void goToFloor(int dest){
        buttonPanel.callDispatcher(new ElevatorEvent(dest, carNo, dest > currentFloor ? UP : DOWN));
    }
}

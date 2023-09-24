package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Car> cars = new ArrayList();
    private final List<Floor> floors = new ArrayList();

    public Building(int cars, int floors) {
        init(cars, floors);
    }

    private void init(int cars, int floors){
        for(int i = 0; i < cars; i++)
            this.cars.add(new Car(new CarButtonPanel(), i, floors));
        for(int i = 0; i < floors; i++)
            this.floors.add(new Floor(i, new Door(), new FloorButtonPanel()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Floor> getFloors() {
        return floors;
    }

}

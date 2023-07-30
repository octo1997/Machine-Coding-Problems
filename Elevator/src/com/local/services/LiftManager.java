package com.local.services;

import com.local.entities.Car;
import com.local.entities.Floor;
import com.local.entities.buttons.ButtonPanel;

import java.util.ArrayList;
import java.util.List;

public class LiftManager {
    private static LiftManager instance = new LiftManager();
    private LiftManager(){};
    private List<Car> cars = new ArrayList();
    private List<Floor> floors = new ArrayList();

    public boolean startService(int car, int floors){
        for(int i = 0; i <= car; i++) cars.add(new Car(i, 1, 1));
        for(int i = 0; i <= floors; i++) this.floors.add(new Floor(new ButtonPanel(), i));
        return true;
    }

    public void stopService(){}

    public static LiftManager getInstance() {
        return instance;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}

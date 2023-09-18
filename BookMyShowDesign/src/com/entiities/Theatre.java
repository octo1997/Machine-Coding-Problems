package com.entiities;

import com.Util.Slot;

import java.util.HashMap;
import java.util.Map;

public class Theatre {
    private final String theatreId;
    private String location;
    private String name;
    private final Map<String, Hall> hallMap = new HashMap();
    private int halls = 0;
    private static final int noOfSeats = 100;
    public Theatre(String theatreId, String location, String name, int halls) {
        this.theatreId = theatreId;
        this.location = location;
        this.name = name;
        this.halls = halls;
        init();
    }

    private void init(){
        hallMap.clear();
        for(int i = 0; i < halls; i++) hallMap.put(Integer.toString(i), new Hall(Integer.toString(i), noOfSeats));
    }

    public Hall getHall(String hallId){
        return hallMap.get(hallId);
    }

    public void addShow(Slot slot, String show, String hallId){
        Hall hall = hallMap.get(hallId);
        hall.addShow(slot, show);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Hall> getHallMap() {
        return hallMap;
    }

    public int getHalls() {
        return halls;
    }

    public void setHalls(int halls) {
        this.halls = halls;
    }
}

package com.entiities;

import com.Util.SeatType;
import com.Util.Slot;

import java.util.HashMap;
import java.util.Map;

import static com.Util.SeatType.ECONOMY;

public class Hall {
    private final Map<Slot, Map<String, Seat>> slotMap = new HashMap<Slot, Map<String, Seat>>();
    private final Map<Slot, String> slotShowMap = new HashMap<Slot, String>();
    private final String hallId;
    private final int noOfSeats;

    public Hall(String hallId, int noOfSeats) {
        this.hallId = hallId;
        this.noOfSeats = noOfSeats;
        init();
    }

    private void init(){
        slotMap.clear();
        slotShowMap.clear();
    }

    public void addShow(Slot slot, String showName) {
        if(slotShowMap.containsKey(slot)){
            System.out.println("Hall already occupied :sad:");
            return;
        }
        slotShowMap.put(slot, showName);
        slotMap.put(slot, new HashMap<String, Seat>());
        for(int i = 0; i < noOfSeats; i++){
            slotMap.get(slot).put(Integer.toString(i), new Seat(Integer.toString(i), ECONOMY));
        }
    }


    public Map<Slot, Map<String, Seat>> getSlotMap() {
        return slotMap;
    }

    public Map<Slot, String> getSlotShowMap() {
        return slotShowMap;
    }

    public String getHallId() {
        return hallId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }
}

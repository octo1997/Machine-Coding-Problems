package com.local.entities;

import java.util.*;

import com.local.exception.InvalidTicketException;
import com.local.exception.NotAvailableException;
import com.local.plans.FloorPlan;
import com.local.plans.FloorPlan1;
import com.local.services.TicketService;

public class ParkingLot {
	
	private String id;
	private Floor[] floors;
	private FloorPlan[] floorPlans;
	
	private final Map<Integer, Set<Slot>> occupiedSlots = new HashMap<Integer, Set<Slot>>();

	public ParkingLot(int floors, int slots, String id) {
		this.id = id;
		this.floorPlans = new FloorPlan[floors];
		this.floors = new Floor[floors];
		initFloors(slots);
		
	}

	
	private void initFloors(int slots) {
		for(int i = 0; i < floors.length; i++) {
			floorPlans[i] = new FloorPlan1();
			floors[i] = floorPlans.length > 0 ? new Floor(slots, Integer.toString(i + 1), floorPlans[i]) 
											: new Floor(slots, Integer.toString(i + 1), new FloorPlan1());
		}
		
		System.out.println("Created parking lot with " + Integer.toString(floors.length) + " and "
		+ Integer.toString(slots) + " slots per floor");
	}

	public String parkNALSlot(VehicleType vehicleType) throws NotAvailableException {
		for(int i = 0; i < floors.length; i++) {
			Slot slot = floors[i].findAvalaibleSlot(vehicleType);
			if(slot != null) {
				floors[i].parkSlot(slot);
				return TicketService.getInstance().generateTicketId(this.id, floors[i].getId(), slot.getId());
			}
		}
		throw new NotAvailableException();
	}
	
	public void printFreeSlots(VehicleType vehicleType) {
		for(Floor floor : floors) {
			floor.printFreeSlots(vehicleType);
		}
	}
	
	public void printOccupiedSlots(VehicleType vehicleType) {
		for(Floor floor : floors) {
			floor.printOccupiedSlots(vehicleType);
		}
	}
	
	public void printFreeSlotsCount(VehicleType vehicleType) {
		for(Floor floor : floors) {
			floor.printFreeSlotsCount(vehicleType);
		}
	}

	public void unPark(String ticketId) throws NumberFormatException, InvalidTicketException {
		
		String floorId = TicketService.getInstance().getFloorIdFromTicketId(ticketId);
		
		floors[getFloorNumFromId(floorId)].unPark(ticketId);
	}
	
	private int getFloorNumFromId(String floorId) {
		return Integer.parseInt(floorId) - 1;
	}

}

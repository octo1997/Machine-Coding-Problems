package com.local.entities;

import java.util.*;

import com.local.exception.InvalidTicketException;
import com.local.plans.FloorPlan;
import com.local.services.TicketService;

public class Floor {
	private String id;
	private Slot[] slots;
	private FloorPlan floorPlan;
	private final Map<VehicleType, Set<Slot>> freeSlots = new HashMap<VehicleType, Set<Slot>>();

	public Floor(int slots, String id, FloorPlan floorPlan) {
		this.id = id;
		this.floorPlan = floorPlan;
		this.slots = new Slot[slots];
		initSlots(slots);
	}
	
	public String getId() {
		return id;
	}
	
	private void initSlots(int slots) {
		for(int i = 0; i < slots; i++) {
			this.slots[i] = SlotBuilder.generate(floorPlan, i + 1);
			if(!freeSlots.containsKey(this.slots[i].getVehicleType())) freeSlots.put(this.slots[i].getVehicleType(), new TreeSet<Slot>());
			freeSlots.get(this.slots[i].getVehicleType()).add(this.slots[i]);
		}
	}

	public Slot findAvalaibleSlot(VehicleType vehicleType) {
		Slot slot = null;
		if(!freeSlots.get(vehicleType).isEmpty()) {
			slot = freeSlots.get(vehicleType).iterator().next();
		}
		
		return slot;
	}
	
	

	public void printFreeSlots(VehicleType vehicleType) {
		System.out.print("Free slots for " + vehicleType + " on Floor " + this.id + ": ");
		freeSlots.get(vehicleType).stream().forEach(a -> System.out.print(a.getId()));
		System.out.println();
	}
	
	public void printFreeSlotsCount(VehicleType vehicleType) {
		System.out.print("No. of free slots for " + vehicleType + " on Floor " + this.id + ": ");
		System.out.println(freeSlots.get(vehicleType).size());
	}
	
	public void printOccupiedSlots(VehicleType vehicleType) {
		System.out.print("Occupied slots for " + vehicleType + " on Floor " + this.id + ": ");
		for(int i = 0; i < slots.length; i++) {
			if(!slots[i].isAvailable()) System.out.print(slots[i].getId());
		}
		System.out.println();
	}

	
	
	public void parkSlot(Slot slot) {
		markSlotAvailable(slot, false);
	}
	
	public void unPark(String ticketId) throws InvalidTicketException {
		String slotId = TicketService.getInstance().getSlotIdFromTicketId(ticketId);
		int id = getSlotNumFromId(slotId);
		
		if(id < 0 || id >= slots.length) throw new InvalidTicketException(ticketId);
		
		markSlotAvailable(slots[id - 1], true);
		
	}
	
	private int getSlotNumFromId(String slotId) {
		return Integer.parseInt(slotId) - 1;
	}
	
	private void markSlotAvailable(Slot slot, boolean available) {
		slot.setAvailable(available);
		if(available)
			freeSlots.get(slot.getVehicleType()).add(slot);
		else
			freeSlots.get(slot.getVehicleType()).remove(slot);
	}
	
	
	

}

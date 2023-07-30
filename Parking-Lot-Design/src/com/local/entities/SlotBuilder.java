package com.local.entities;

import com.local.plans.FloorPlan;

public class SlotBuilder {
	
	public static Slot generate(FloorPlan floorPlan, int i) {
		return switch(floorPlan.getVehicleType(i)) {
			case BIKE -> new BikeSlot(Integer.toString(i));
			case CAR -> new CarSlot(Integer.toString(i));
			case TRUCK -> new TruckSlot(Integer.toString(i));
			default -> throw new IllegalArgumentException("Unexpected value: " + floorPlan.getVehicleType(i));
		};
	}

}

package com.local.entities;

public class TruckSlot extends Slot {
	
	private final VehicleType vehicleType = VehicleType.TRUCK;

	public TruckSlot(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
}

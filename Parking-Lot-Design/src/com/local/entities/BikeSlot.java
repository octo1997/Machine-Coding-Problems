package com.local.entities;

public class BikeSlot extends Slot{
	
	private final VehicleType vehicleType = VehicleType.BIKE;

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public BikeSlot(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}

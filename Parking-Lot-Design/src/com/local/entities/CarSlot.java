package com.local.entities;

public class CarSlot extends Slot {

	public CarSlot(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private final VehicleType vehicleType = VehicleType.CAR;

	public VehicleType getVehicleType() {
		return vehicleType;
	}
}

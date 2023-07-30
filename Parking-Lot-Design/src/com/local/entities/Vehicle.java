package com.local.entities;

public class Vehicle {
	private final VehicleType vehicleType;
	private final String vehNo;
	private final String Color;
	
	
	public Vehicle(VehicleType vehicleType, String vehNo, String color) {
		super();
		this.vehicleType = vehicleType;
		this.vehNo = vehNo;
		Color = color;
	}


	public VehicleType getVehicleType() {
		return vehicleType;
	}


	public String getVehNo() {
		return vehNo;
	}


	public String getColor() {
		return Color;
	}


	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", vehicleNo=" + vehNo + ", Color=" + Color + "]";
	}
	
	
	
	
	
	
}

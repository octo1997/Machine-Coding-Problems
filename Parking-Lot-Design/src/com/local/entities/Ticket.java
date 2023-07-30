package com.local.entities;

public class Ticket {
	private final String id;
	private final Vehicle vehicle;

	public Ticket(String id, Vehicle vehicle) {
		this.id = id;
		this.vehicle = vehicle;
	}

	public String getId() {
		return id;
	}
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	

}

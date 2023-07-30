package com.local.entities;

public abstract class Slot implements Comparable<Slot>{
	
	private boolean isAvailable;
	private String id;
	
	
	
	public Slot(String id) {
		super();
		this.id = id;
		isAvailable = true;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getId() {
		return id;
	}
	
	public abstract VehicleType getVehicleType();
	
	
	@Override
	public int compareTo(Slot o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(id) < Integer.parseInt(o.id) ? - 1 : 1;
	}


	@Override
	public int hashCode() {
		return id.hashCode();
	}
}

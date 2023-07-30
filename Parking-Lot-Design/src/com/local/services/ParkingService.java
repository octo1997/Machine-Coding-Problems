package com.local.services;

import com.local.entities.ParkingLot;
import com.local.entities.Ticket;
import com.local.entities.Vehicle;
import com.local.entities.VehicleType;
import com.local.exception.InvalidTicketException;
import com.local.exception.NotAvailableException;

public class ParkingService {
	
	private ParkingLot parkingLot = null;
	
	private String pLotId;
	
	public void createParkingLot(String plotId, int floor, int slots) {
		this.pLotId = plotId;
		parkingLot = new ParkingLot(floor, slots, pLotId);
	}
	
	public void parkVehicle(VehicleType vehicleType, String vehNo, String color) {
		try {
			String id = parkingLot.parkNALSlot(vehicleType);
			Ticket ticket = TicketService.getInstance().generateTicket(id, new Vehicle(vehicleType, vehNo, color));
			System.out.println(ticket.getId());
		}
		catch(NotAvailableException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void unparkVehicle(String ticketId) {
		try {
			Vehicle vehicle = TicketService.getInstance().resolveTicket(ticketId);
			parkingLot.unPark(ticketId);
			System.out.println(vehicle);
		}catch(InvalidTicketException ite) {
			System.out.println(ite.getMessage());
			//log somewhere
		}
		
	}
	
	public void printFreeSlots(VehicleType vehicleType) {
		parkingLot.printFreeSlots(vehicleType);
	}
	
	public void printOccupiedSlots(VehicleType vehicleType) {
		parkingLot.printOccupiedSlots(vehicleType);
	}
	
	public void printFreeSlotsCount(VehicleType vehicleType) {
		parkingLot.printFreeSlotsCount(vehicleType);
	}

}

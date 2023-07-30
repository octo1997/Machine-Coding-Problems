package com.local.services;

import java.util.HashMap;
import java.util.Map;

import com.local.entities.Ticket;
import com.local.entities.Vehicle;
import com.local.exception.InvalidTicketException;

public class TicketService {
	
	private static TicketService instance = new TicketService();
	private Map<String, Vehicle> ticketMap = new HashMap<String, Vehicle>();
	
	private TicketService() {}
	
	public static TicketService getInstance() {
		return instance;
	}
	
	public Ticket generateTicket(String slotId, Vehicle vehicle) {
		
		Ticket ticket = new Ticket(slotId, vehicle); 
		ticketMap.put(ticket.getId(), vehicle);
		 
		return ticket;
	}
	
	public Vehicle resolveTicket(String ticketId) throws InvalidTicketException{
		if(ticketMap.containsKey(ticketId)) {
			Vehicle vehicle = ticketMap.get(ticketId);
			return vehicle;
		}
		throw new InvalidTicketException(ticketId);
	}
	
	public String generateTicketId(String pLot, String floor, String slot) {
		return pLot + "_" + floor + "_" + slot;
	}
	
	public String getFloorIdFromTicketId(String ticketId) {
		String floor = ticketId.split("_")[1];
		return floor;
	}
	
	public String getSlotIdFromTicketId(String ticketId) {
		String slot = ticketId.split("_")[2];
		return slot;
	}

}

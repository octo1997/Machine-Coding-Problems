package com.manager;

import com.entiities.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {
    private TicketManager() {
    }

    private final static TicketManager instance = new TicketManager();
    private static int cnt = 0;

    public static TicketManager getInstance() {
        return instance;
    }

    private final Map<String, Ticket> ticketMap = new HashMap();
    public Ticket createTicket(String uName, String theatreId, String hallId, String transactionNo){
        String id = Integer.toString(cnt++);
        Ticket ticket = new Ticket(id, uName, transactionNo, theatreId, hallId);
        ticketMap.put(id, ticket);
        return ticket;
    }
}

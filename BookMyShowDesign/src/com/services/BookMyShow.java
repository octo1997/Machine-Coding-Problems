package com.services;

import com.Util.Slot;
import com.entiities.Seat;
import com.entiities.Ticket;
import com.manager.TheatreManager;
import com.manager.TicketManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class BookMyShow {
    private BookMyShow(){}

    private static final BookMyShow instance = new BookMyShow();

    public static BookMyShow getInstance() {
        return instance;
    }

    public void createTheatre(String loc, String name){
        TheatreManager.getInstance().addTheatre(loc, name);
    }

    public void hostShow(String showName, Date startTime, Date endTime, String theatreId, String hallId){
        TheatreManager.getInstance().getTheatre(theatreId).addShow(new Slot(startTime, endTime), showName, hallId);
    }

    public void viewShowsAtMyLocation(String loc){
        System.out.println(TheatreManager.getInstance().getShowsByLocation(loc));
    }

    public void viewTheatresByShowsAtMyLocation(String loc, String show){
        System.out.println(TheatreManager.getInstance().getTheatreByShowsAtMyLocation(loc, show));
    }

    public void bookAShow(String hallId, String theatreId, String seatId, String userName, String sDate, String eDate) throws ParseException {
        Seat desiredSeat = TheatreManager.getInstance().getTheatre(theatreId).getHall(hallId).getSlotMap().get(new Slot(new SimpleDateFormat("dd/mm/yyyy").parse(sDate),
                new SimpleDateFormat("dd/mm/yyyy").parse(eDate))).get(seatId);
        desiredSeat.lockSeat();
        //payment gateway
        //if payment success then
        desiredSeat.reserve();
        //generate ticket with username
        Ticket ticket = TicketManager.getInstance().createTicket(userName, theatreId, hallId, "abc");
        System.out.println(ticket);
    }

    public void cancelTicket(){

    }

}

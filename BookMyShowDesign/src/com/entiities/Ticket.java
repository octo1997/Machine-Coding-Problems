package com.entiities;

public class Ticket {
    private final String ticketId;
    private String ticketStatus, userId, transactionNo, theatreId, hallId;

    public Ticket(String ticketId, String userId, String transactionNo, String theatreId, String hallId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.transactionNo = transactionNo;
        this.theatreId = theatreId;
        this.hallId = hallId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", theatreId='" + theatreId + '\'' +
                ", hallId='" + hallId + '\'' +
                '}';
    }
}

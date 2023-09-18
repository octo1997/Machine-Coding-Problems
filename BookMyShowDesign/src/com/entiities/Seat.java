package com.entiities;

import com.Util.SeatStatus;
import com.Util.SeatType;

public class Seat {
    private static final int waitTime = 30000;
    private final String seatId;
    private final SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        seatStatus = SeatStatus.UNBOOKED;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public void lockSeat(){
        synchronized (this){
            seatStatus = SeatStatus.LOCKED;
        }
        if(seatStatus.equals(SeatStatus.LOCKED)){
            new Thread(new selfUnreserve()).start();
        }
    }

    public void reserve(){
        setSeatStatus(SeatStatus.BOOKED);
    }

    private class selfUnreserve implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(waitTime);

                synchronized (this){
                    if(getSeatStatus().equals(SeatStatus.LOCKED)) setSeatStatus(SeatStatus.UNBOOKED);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

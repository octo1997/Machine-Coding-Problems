package com.entities;

public class Share {
    private String participant;
    private double amt;

    public Share(String participant, double amt) {
        this.participant = participant;
        this.amt = amt;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}

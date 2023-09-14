package com.entities;

import com.entities.Share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Expense {
    private String payer;
    private String id;
    protected final List<Share> shareList = new ArrayList();
    protected final Map<String, Double> shareMap = new HashMap();
    private double totalAmount;


    public Expense(String payer, double totalAmount, List<String> participants, List<Double> shares, String id) {
        this.payer = payer;
        this.totalAmount = totalAmount;
        this.id = id;
        init(participants, shares);
    }



    protected abstract void init(List<String> participants, List<Double> shares);

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public List<Share> getShareList() {
        return shareList;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance(String user) {
        if(user.equals(payer)){
            return 0.0;
        }
        return shareMap.get(user);
    }
}

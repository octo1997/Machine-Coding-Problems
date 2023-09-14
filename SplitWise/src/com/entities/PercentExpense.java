package com.entities;

import java.util.List;

public class PercentExpense extends Expense {


    public PercentExpense(String payer, double totalAmount, List<String> participants, List<Double> shares, String id) {
        super(payer, totalAmount, participants, shares, id);
    }

    @Override
    protected void init(List<String> participants, List<Double> shares) {
        for (int i = 0; i < participants.size(); i++) {
            if(participants.get(i).equals(getPayer())) shareList.add(new Share(participants.get(i), getPercent(shares.get(i))));
            else shareList.add(new Share(participants.get(i), -getPercent(shares.get(i))));
            shareMap.put(participants.get(i), shareList.get(shareList.size() - 1).getAmt());
        }
    }

    private double getPercent(double pCent){
        return (pCent * getTotalAmount() / 100.0);
    }
}

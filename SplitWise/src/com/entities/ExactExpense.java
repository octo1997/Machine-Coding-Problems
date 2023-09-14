package com.entities;

import java.util.List;

public class ExactExpense extends Expense {


    public ExactExpense(String payer, double totalAmount, List<String> participants, List<Double> shares, String id) {
        super(payer, totalAmount, participants, shares, id);
    }

    @Override
    protected void init(List<String> participants, List<Double> shares) {
        for (int i = 0; i < participants.size(); i++) {
            if(participants.get(i).equals(getPayer())) shareList.add(new Share(participants.get(i), shares.get(i)));
            else shareList.add(new Share(participants.get(i), -shares.get(i)));
            shareMap.put(participants.get(i), shareList.get(shareList.size() - 1).getAmt());
        }
    }
}

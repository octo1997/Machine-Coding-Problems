package com.entities;

import java.util.List;

public class EqualExpense extends Expense {


    public EqualExpense(String payer, double totalAmount, List<String> participants, List<Double> shares, String id) {
        super(payer, totalAmount, participants, shares, id);
    }

    @Override
    protected void init(List<String> participants, List<Double> shares) {
        double perheadShare = getTotalAmount() / participants.size();

        for(String participant: participants){
            if(participant.equals(getPayer())) shareList.add(new Share(participant, 0));
            else shareList.add(new Share(participant, -perheadShare));
            shareMap.put(participant, shareList.get(shareList.size() - 1).getAmt());
        }
    }
}

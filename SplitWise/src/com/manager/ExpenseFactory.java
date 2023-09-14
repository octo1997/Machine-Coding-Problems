package com.manager;

import com.entities.*;

import java.util.List;

public class ExpenseFactory {
    private static int counter = 0;
    public static Expense getNewExpense(ExpenseType expenseType, String payer, double totalAmount, List<String> participants, List<Double> shares){
        return switch (expenseType){
            case EQUAL -> new EqualExpense(payer, totalAmount, participants, shares, Integer.toString(counter++));
            case EXACT -> new ExactExpense(payer, totalAmount, participants, shares, Integer.toString(counter++));
            case PERCENT -> new PercentExpense(payer, totalAmount, participants, shares, Integer.toString(counter++));
            default -> null;
        };
    }
}

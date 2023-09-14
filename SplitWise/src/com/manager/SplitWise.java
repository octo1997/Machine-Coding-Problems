package com.manager;

import com.entities.Expense;
import com.entities.ExpenseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWise {
    private static final SplitWise instance = new SplitWise();
    private SplitWise(){};

    public static SplitWise getInstance() {
        return instance;
    }

    private final Map<String, List<String>> userExpenseMap = new HashMap();
    private final Map<String, Expense> expenseMap = new HashMap();

    public void addUser(String id, String name, String email, String mob){
        UserManager.getInstance().addUser(id, name, email, mob);
        userExpenseMap.put(id, new ArrayList());
    }

    public void addExpense(String payerId, double amt, ExpenseType type, List<String> contributors, List<Double> shares){
        Expense expense = ExpenseFactory.getNewExpense(type, payerId, amt, contributors, shares);
        synchronized (expenseMap) {
            expenseMap.put(expense.getId(), expense);
        }
        synchronized (userExpenseMap){
            for (int i = 0; i < contributors.size(); i++) userExpenseMap.get(contributors.get(i)).add(expense.getId());
        }

    }

    public void showUserBalance(String userId){
        List<String> expenseIds = userExpenseMap.get(userId);
        Map<String, Double> balanceMap = new HashMap();
        for(String expenseId: expenseIds){
            Expense expense = expenseMap.get(expenseId);
            balanceMap.put(expense.getPayer(), balanceMap.getOrDefault(userId, 0.0) + expense.getBalance(userId));
        }
        System.out.println(balanceMap);
    }

    public void showBalances(){
        Map<String, Map<String, Double>> balanceMap = new HashMap();
        UserManager.getInstance().getUserMap().forEach((k,v) -> {
            balanceMap.put(k, new HashMap());
        });

        for(Map.Entry<String, Expense> expenseEntry: expenseMap.entrySet()){
            Expense expense = expenseEntry.getValue();
            expense.getShareList().forEach(k -> {
                Map<String, Double> temp =  balanceMap.get(k.getParticipant());
                temp.put(expense.getPayer(), temp.getOrDefault(expense.getPayer(), 0.0) + expense.getBalance(k.getParticipant()));
            });
        }
        System.out.println(balanceMap);
    }
}

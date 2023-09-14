import com.entities.ExpenseType;
import com.manager.SplitWise;
import com.manager.UserManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean completed = false;
        SplitWise.getInstance().addUser("u1", "U1", "u1@g.com","1234");
        SplitWise.getInstance().addUser("u2", "U2", "u2@g.com","1234");
        SplitWise.getInstance().addUser("u3", "U3", "u3@g.com","1234");
        SplitWise.getInstance().addUser("u4", "U4", "u4@g.com","1234");
        while(!completed){
            String[] temp = scanner.nextLine().split(" ");
            switch (temp[0]){
                case "SHOW" -> {
                    if(temp.length == 1) {
                        SplitWise.getInstance().showBalances();
                    }
                    else{
                        SplitWise.getInstance().showUserBalance(temp[1]);
                    }
                }
                case "EXPENSE" -> {
                    double amt = Double.parseDouble(temp[2]);
                    String payer = temp[1];
                    int contri = Integer.parseInt(temp[3]), i = 0;
                    List<String> recievers = new ArrayList<String>();
                    List<Double> amts = new ArrayList<Double>();
                    while(i < contri) recievers.add(temp[4 + i++]);
                    ExpenseType expenseType = ExpenseType.valueOf(temp[4 + i++]);
                    if(expenseType == ExpenseType.PERCENT){
                        int j = 0;
                        while(j < contri){
                            amts.add(Double.parseDouble(temp[4 + i + j++]));
                        }
                    }
                    SplitWise.getInstance().addExpense(payer, amt, expenseType, recievers, amts);
                }

                default -> {
                    completed = true;
                }

            }
        }

        scanner.close();
    }
}
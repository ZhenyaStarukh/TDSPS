package com.company;

import java.text.DecimalFormat;

public class ExpensesService {

    public static double buyPigments(){
        DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        double expenses=0.0;
        for (Color color:Color.values()){
            if(color.getWeight()<300.0){
                System.out.println(color.getName()+":  "+decFormat.format(color.getWeight()));
                expenses+=(1000-color.getWeight())*color.getPrice();
                color.setWeight(1000.0);
            }
        }
        return expenses;
    }

    public static void addToPillow(double income, double expenses){
        DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        System.out.println("Expenses: "+decFormat.format(expenses)+"\nIncome: "+decFormat.format(income)+"\nPillow: "
                +decFormat.format(Shop.getPillow()));
        if(expenses>income){
            Shop.setPillow(Shop.getPillow()-(expenses-income));
        }
        else{
            income -= expenses;
            Shop.setPillow(Shop.getPillow()+income);
        }
        System.out.println("Expenses: "+decFormat.format(expenses)+"\nIncome: "+decFormat.format(Cashier.getCurrentBalance())
                +"\nPillow: "+decFormat.format(Shop.getPillow()));
    }
}

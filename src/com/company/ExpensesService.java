package com.company;

import java.text.DecimalFormat;

public final class ExpensesService {

    public double buyPigments(){
        double expenses = 0.0;

        for (Color color:Color.values()){

            if(color.getWeight() < 300.0){
                expenses += (1000-color.getWeight()) * color.getPrice();
                color.setWeight(1000.0);
            }

        }
        return expenses;
    }

    public void addToPillow(double income, double expenses, Shop shop){
        DecimalFormat decFormat = new DecimalFormat("#,##0.00");

        //these prints are only for showing in the example
        System.out.println("Expenses: "+decFormat.format(expenses)+"\nIncome: "+decFormat.format(income)+"\nPillow: "
                +decFormat.format(shop.getPillow()));
        System.out.println("_______________\nResult:");

        if(expenses > income) shop.setPillow(shop.getPillow() - (expenses-income));
        else{
            income -= expenses;
            shop.setPillow(shop.getPillow() + income);
        }

        System.out.println("Pillow: "+decFormat.format(shop.getPillow()));
    }
}

package com.company;

public class ExpensesService {
    public static double buyPigments(){
        double expenses=0.0;
        for (Color color:Color.values()){
            if(color.getWeight()<1000.0){
                expenses+=(1000-color.getWeight())*color.getPrice();
                color.setWeight(1000.0);
            }
        }
        return expenses;
    }
    public static void addToPillow(double income, double expenses){
        if(expenses>income){
            Shop.setPillow(Shop.getPillow()-(expenses-income));
        }
        else{
            income -= expenses;
            Shop.setPillow(Shop.getPillow()+income);
        }
    }
}

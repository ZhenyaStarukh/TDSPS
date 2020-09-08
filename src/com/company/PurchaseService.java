package com.company;

public class PurchaseService {


    private static void checkPigments(Order order){
        for (Color color: Color.values()){
            if(order.countPigment(color.ordinal())>color.getWeight()){

            }
        }

    }
    private static boolean haveDiscount(){
        //...
        return true;
    }
    private static void ShowTotal(){

    }
    // add another functions
    public static void Purchase(){

    }

}

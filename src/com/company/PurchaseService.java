package com.company;

public class PurchaseService {


    public static void checkPigments(Order order){
        for (Color color: Color.values()){
            while(order.countPigment(color.ordinal())>color.getWeight()){
                System.out.println("There is not enough pigment: "+color.getName()+
                        "\nYou can remove pigment.");
                order.removePigment();
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

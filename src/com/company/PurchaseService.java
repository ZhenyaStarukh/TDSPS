package com.company;

import java.util.Scanner;

public class PurchaseService {


    private static void checkPigments(Order order){
        for (Color color: Color.values()){
            while(order.countPigment(color.ordinal())>color.getWeight()){
                System.out.println("There is not enough pigment: "+color.getName()+
                        "\nYou can remove pigment.");
                order.removePigment();
            }
        }

    }
    private static boolean haveDiscount(Order order){
        if(order.getId().equals("None")) return false;
        return true;
    }

    public static void Purchase(Order order){
        checkPigments(order);
        System.out.println();
        order.showTotal();
        System.out.println("Do you want to make a purchase?\ny-yes  n-no");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if(ans.equals("n")) return;
        if(haveDiscount(order)) order.setDiscount();
        order.showTotal();
        //add to cashier


    }

}

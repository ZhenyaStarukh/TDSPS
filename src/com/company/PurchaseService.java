package com.company;

import java.text.DecimalFormat;
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
        //DecimalFormat decimalFormat = new DecimalFormat("#,###0.00");
        checkPigments(order);
        order.calculateTotalPrice();
        order.showTotal();
        System.out.println("Do you want to make a purchase?\ny-yes  n-no");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if(ans.equals("n")) return;
        if(haveDiscount(order)) order.setDiscount();
        order.showTotal();
        Cashier.addToCashier(order.getTotalPrice());
        for(Color color: Color.values()){
            //System.out.print(color.getName()+": "+decimalFormat.format(color.getWeight())+"  -  ");
            color.reduceWeight(order.countPigment(color.ordinal()));
            //System.out.println(decimalFormat.format(color.getWeight()));
        }


    }

}

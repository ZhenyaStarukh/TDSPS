package com.company;


import java.util.Scanner;

public class PurchaseService {

    private void checkPigments(Order order){

        for (Color color: Color.values()){

            while(order.countPigment(color.ordinal())>color.getWeight()){
                System.out.println("There is not enough pigment: "+color.getName()+
                        "\nYou can remove pigment.");
                Scanner in = new Scanner(System.in);
                order.removePigment(Integer.parseInt(in.nextLine()));
            }
        }

    }

    private boolean haveDiscount(Order order){
        return !order.getId().equals("None");
    }

    public void Purchase(Order order,String ans,Cashier cashier){
        checkPigments(order);
        order.calculateTotalPrice();
        order.showTotal();

        if(ans.equals("no")) {
            System.out.println("_____Order cancelled_____");
            return;
        }

        if(haveDiscount(order)) order.setDiscount();

        order.showTotal();
        cashier.addToCashier(order.getTotalPrice());

        for(Color color: Color.values()){
            color.reduceWeight(order.countPigment(color.ordinal()));
        }


    }

}

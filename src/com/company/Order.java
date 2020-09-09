package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private final ArrayList<Pigment> orderList = new ArrayList<>();
    private final Client client;
    private double totalPrice;
    public Order(Client client){
        this.client = client;
    }

    public void createPigment(){
        double weight;
        Pigment pigment = new Pigment(client);

        Scanner in = new Scanner(System.in);
        String ans;

        System.out.println("Do you want to alter the formula?\ny-yes  n-no");
        ans = in.nextLine();
        if(ans.equals("y")) pigment.alterFormula();

        System.out.println("Do you want to save your pigment?\ny-yes  n-no");
        ans = in.nextLine();
        if(ans.equals("y")) pigment.savePigment();

        System.out.println("Enter weight in grams.");
        weight = Double.parseDouble(in.nextLine());
        pigment.setWeight(weight);

        System.out.println("Do you want to add an effect?\ny-yes n-no");
        ans = in.nextLine();
        if(ans.equals("y")) pigment.addEffect();

        orderList.add(pigment);
    }

    public void choosePigment(){
        double weight;
        Shop.printPigments(client);
        System.out.println("Choose the number of pigment you want to add.");

        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine())-1;

        System.out.println("Enter weight in grams.");
        weight = Double.parseDouble(in.nextLine());
        Pigment pigment = Shop.getPigment(number);
        pigment.setWeight(weight);

        System.out.println("Do you want to add an effect?\ny-yes n-no");
        String ans = in.nextLine();
        if(ans.equals("y")) pigment.addEffect();

        orderList.add(pigment);
    }

    public void printOrder(){
        System.out.println("\nYour order:");
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        for(int i = 0;i<orderList.size();i++){
            System.out.print((i+1)+") "+orderList.get(i).getName()+"  ");

            if(orderList.get(i).haveEffects()) System.out.print("("+orderList.get(i).getEffects()+")  ");

            System.out.println(decimalFormat.format(orderList.get(i).totalPrice())+" UAH    "
                    + decimalFormat.format(orderList.get(i).getWeight())+"g");
        }
    }

    public void removePigment(){
        printOrder();
        System.out.println("Choose a number of pigment you want to remove:");
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine())-1;

        System.out.println("Do you really want to remove pigment "+ orderList.get(number).getName()+" from your order list?\ny-yes n-no");
        String ans = in.nextLine();
        if(ans.equals("y")) {
            orderList.remove(number);
            System.out.println("Pigment is removed.");
        }
    }

    public double countPigment(int index){
        double count = 0.0;

        for (Pigment pigment : orderList) {
            count += pigment.getWeight() * pigment.getFormula(index);
        }
        //System.out.println(Color.values()[index].getName()+":  "+count);
        return count;
    }

    public String getId(){return client.getId();}

    public void calculateTotalPrice(){
        totalPrice = 0.0;

        for (Pigment pigment : orderList) {
            totalPrice += pigment.totalPrice();
        }
    }
    public double getTotalPrice(){
        return totalPrice;
    }

    public void setDiscount(){
        totalPrice -=totalPrice*0.05;
        System.out.println("We have a discount 5% for registered customers!");
    }

    public void showTotal(){
        printOrder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println("___________________________________________");
        System.out.println("Total price:\t\t\t\t\t"+decimalFormat.format(totalPrice)+" UAH");
    }
}

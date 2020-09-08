package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Pigment> orderList = new ArrayList<>();
    private Client client;
    private double totalPrice;
    public Order(Client client){
        this.client = client;
    }
    public void createPigment(){
        double weight;
        Pigment pigment = new Pigment(client);
        System.out.println("Do you want to save your pigment?\ny-yes  n-no");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if(ans.equals("y")) pigment.savePigment();
        System.out.println("Enter weight in grams.");
        weight = Double.parseDouble(in.nextLine());
        pigment.setWeight(weight);
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
        orderList.add(pigment);
    }
    public void printOrder(){
        System.out.println("\nYour order:");
        for(int i = 0;i<orderList.size();i++){
            System.out.println((i+1)+") "+orderList.get(i).getName()+"  "
                    +orderList.get(i).totalPrice()+" UAH    "+ orderList.get(i).getWeight()+"g");
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
        for(int i=0;i<orderList.size();i++){
            count += orderList.get(i).getWeight() * orderList.get(i).getFormula(index);
        }
        //System.out.println(Color.values()[index].getName()+":  "+count);
        return count;
    }

    public String getId(){return client.getId();}
    public void calculateTotalPrice(){
        totalPrice = 0.0;
        for(int i =0;i<orderList.size();i++){
            totalPrice+=orderList.get(i).totalPrice();
        }
    }
    public double getTotalPrice(){
        return totalPrice;
    }

    public void setDiscount(){
        double finalPrice = getTotalPrice();
        finalPrice -= finalPrice*0.05;
        totalPrice = finalPrice;
    }
    public void showTotal(){
        printOrder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println("___________________________________________");
        calculateTotalPrice();
        System.out.println("Total price:\t\t\t\t\t"+decimalFormat.format(totalPrice)+" UAH");
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Pigment> orderList = new ArrayList<>();
    private Client client;
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
        Shop.printList();
        System.out.println("Choose the number of pigment you want to add.");
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine())-1;
        //orderList.add(Shop.)
    }
    public void removePigment(){
        //show the list and choose
    }
}

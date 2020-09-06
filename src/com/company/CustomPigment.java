package com.company;

import java.util.Scanner;

public class CustomPigment{
    //private double formula;
    private double weight;
    private double price;
    private String name;
    private Client client;
    //private String effects;
    public CustomPigment(){
        //formula
    }
    public void addEffect(){

    }
    public double totalPrice(){
        return price * weight;
    }
    public void savePigment(){
        System.out.println("Name your new pigment:");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        //...
    }

}

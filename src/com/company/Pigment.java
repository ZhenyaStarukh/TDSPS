package com.company;

import java.util.Scanner;

public class Pigment{
    //private double formula;
    private double price;
    private String name;
    private double weight;
    private Client client;
    //private String effects;
    public Pigment(){
        //formula
    }
    public void addEffect(){

    }

    /*public double totalPrice(){
        return price;
    }*/
    public void savePigment(){
        System.out.println("Name your new pigment:");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        //...
    }
    public double getPrice(){return price;}
    public String getName()
    {return name;}
    public void/*String*/ getFormula(){
        //return formula+effects made into string
    }
    public String getId(){
        return client.getId();
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){return weight;}
}

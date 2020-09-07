package com.company;


import java.util.Scanner;

public class Pigment{
    private double[] formula = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    private double price;
    private String name;
    private double weight;
    private Client client;
    //private String effects;
    private int checkFormula(){
        double sum = 0.0;
        for(int i=0;i<formula.length;i++){
            if(sum>=1) return i;
            sum+=formula[i];
        }
        return 0;
    }
    private double sumFormula(){
        double sum = 0.0;
        for(int i=0;i<formula.length;i++){
            sum+=formula[i];
        }
        return sum;
    }

    //maybe add the separate function that helps to write the formula and then implement it into the constructor smh
    public Pigment(){
        System.out.println("For each color enter from 0(for 0%) to 1(for 100%) to declare the percentage.\nBe aware that" +
                " the sum of all color percentage should be equal to 1 (e.g. you can't have 100% of red and yellow" +
                " at the same time)");
        for(int i = 0;i<formula.length;i++){
            System.out.print(Color.values()[i].getName()+": ");
            Scanner in = new Scanner(System.in);
            double percent = Double.parseDouble(in.next());
            while(percent > 1 && percent < 0 && sumFormula()+percent>1){
                System.out.println("Please enter a number from 0 to 1.\n Remember that the total percentage sum should be <=1");
                percent = Double.parseDouble(in.next());
            }
            formula[i]=percent;
        }

    }

    public void alterFormula(){
        //print the formula and choose what to alter
        //use checkFormula() to check if it's okay
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

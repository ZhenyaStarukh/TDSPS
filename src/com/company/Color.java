package com.company;

public enum Color {
    RED(50.00,10000.00,"Red"),
    YELLOW(60.00,10000.00,"Yellow"),
    BLUE(70.00,10000.00,"Blue"),
    GREEN(45.00,10000.00,"Green"),
    PURPLE(65.00,10000.00,"Purple"),
    BLACK(40.00,10000.00,"Black"),
    WHITE(35.00,10000.00,"White");
    private final double price;
    private double weight;
    private final String name;

    private Color(double price,double weight,String name){
        this.price = price;
        this.weight=weight;
        this.name=name;
    }
    public String getName(){return name;}
    public double getPrice(){return price;}

    public void reduceWeight(double weight){
        //...
        if (weight>this.weight)
            System.out.println("There is not enough pigment.");
        else
            this.weight -= weight;
    }


}

package com.company;

public enum Color {
    CYAN(5.00,1000.00,"Cyan"),
    MAGENTA(7.00,1000.00,"Magenta"),
    YELLOW(6.00,1000.00,"Yellow"),
    BLACK(4.00,1000.00,"Black"),
    WHITE(3.50,1000.00,"White");
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
    public double getWeight(){return weight;}

    public void reduceWeight(double weight){
        if (weight>this.weight)
            System.out.println("There is not enough pigment.");
        else
            this.weight -= weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}

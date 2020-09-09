package com.company;

public enum Effect {
    GLITTER("Glitter", 2.00),
    NACRE("Nacre", 3.50),
    MATTE("Matte", 1.50),
    SHIMMER("Shimmer", 1.50);
    private final String name;
    private final double price;

    Effect(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

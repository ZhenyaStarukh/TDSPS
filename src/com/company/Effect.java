package com.company;

public enum Effect {
    GLITTER("Glitter", 20.00),
    NACRE("Nacre", 35.00),
    MATTE("Matte", 15.00),
    SHIMMER("Shimmer", 15.00);
    private final String name;
    private final double price;

    private Effect(String name, double price){
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

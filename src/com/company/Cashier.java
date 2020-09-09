package com.company;

public class Cashier {
    private static double currentBalance = 0.00;
    private static final double rent = 450.0;

    public static double getRent(){return rent;}

    public static void addToCashier(double sum){
        currentBalance += sum;
    }

    public static double getCurrentBalance(){return currentBalance;}

    public static void resetCurrentBalance(){currentBalance=0.0;}
}

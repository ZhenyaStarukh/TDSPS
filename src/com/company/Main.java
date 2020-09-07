package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Client main = new Client();
        main.setId("+380976543422");
        Shop.addCustomer(main.getId());
        Client one = new Client();
        AvailabilityService.enterShop(one);
        Pigment pigment = new Pigment(one);
        System.out.println("Would you like to alter the formula?\n y-yes n-no");
        Scanner in = new Scanner(System.in);
        if(in.next().equals("y")) pigment.alterFormula();
        pigment.printFormula();
        pigment.addEffect();
        System.out.println(pigment.getFormula());
        System.out.println(pigment.totalPrice());


    }


}

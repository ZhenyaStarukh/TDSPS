package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shop.openShop();


        Client main = new Client();
        main.setId("+380976543422");
        //Shop.addCustomer(main.getId());
        Order order = new Order(main);
        order.createPigment();
        order.choosePigment();
        //order.createPigment();
        //order.choosePigment();
        order.printOrder();
        PurchaseService.Purchase(order);


    }


}

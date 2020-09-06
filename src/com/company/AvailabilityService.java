package com.company;

import java.util.Scanner;

public class AvailabilityService {
    public static boolean enterShop(Client client){
        //check if closed and check authentication
        if(!Shop.isOpen()){
            System.out.println("Sorry! The shop is closed!");
            return false;
        }
        if(client.getId().equals("None")){
            System.out.println("You are unauthorized! Please enter your telephone number (e.g. +380671234567: ");
            Scanner in = new Scanner(System.in);
            client.setId(in.next());
            if (!Shop.inList(client.getId())){
                System.out.println("Number not found. Would you like to register?\ny-yes n-no");
                if (in.next().equals("y")){
                    RegisterService.Register(client);
                }
                else client.setId("None");
            }
        }
        System.out.println("Let's shop!");

        return true;
    }
}

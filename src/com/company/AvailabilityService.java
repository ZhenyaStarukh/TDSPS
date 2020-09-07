package com.company;

import java.util.Scanner;

public class AvailabilityService {
    public static boolean enterShop(Client client){
        if(!Shop.isOpen()){
            System.out.println("Sorry! The shop is closed!");
            return false;
        }
        if(client.getId().equals("None")){
            System.out.println("You are unauthorized! Please enter your telephone number (e.g. +380671234567): ");
            Scanner in = new Scanner(System.in);
            client.setId(in.nextLine());
            if (!Shop.inList(client.getId())){
                System.out.println("Number not found. Would you like to register?\ny-yes n-no");
                String ans = in.nextLine();
                if (ans.equals("y")){
                        RegisterService.Register(client);
                }
                else if (ans.equals("n")) {
                    client.resetId();
                }
            }
            else System.out.println("Welcome back, user "+client.getId());
        }
        System.out.println("Let's shop!");
        return true;
    }
}

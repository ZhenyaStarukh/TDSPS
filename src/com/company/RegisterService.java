package com.company;
import java.util.Scanner;

public class RegisterService {
    static void Register(Client client){
        if (!client.getId().equals("None") && Shop.inList(client.getId()))
            System.out.println("You're already registered!\nYour ID is "+client.getId());
        else if (!client.getId().equals("None")) Shop.addCustomer(client.getId());
        else {
            System.out.println("Enter phone number (e.g. +380976234532): ");
            Scanner in = new Scanner(System.in);
            client.setId(in.next());
            Shop.addCustomer(client.getId());
            System.out.println("\n"+client.getId());
        }
    }
}

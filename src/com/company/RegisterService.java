package com.company;
import java.util.Scanner;

public class RegisterService {

    void Register(Client client, Shop shop, String ans){
       if(ans.equals("no")){
           client.resetId();
           return;
       }
        if (!client.getId().equals("None") && shop.inList(client.getId()))
            System.out.println("You're already registered!\nYour ID is "+client.getId());
        else if (!client.getId().equals("None")) shop.addCustomer(client.getId());
        else {
            System.out.println("Enter phone number (e.g. +380976234532): ");
            Scanner in = new Scanner(System.in);
            client.setId(in.next());
            shop.addCustomer(client.getId());
            System.out.println("\n"+client.getId());
        }
    }
}

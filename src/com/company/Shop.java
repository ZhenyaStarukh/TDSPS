package com.company;
import java.util.ArrayList;
//import java.util.Scanner;

public class Shop {
    private static final ArrayList<String> Customers = new ArrayList<>();
    static void addCustomer(String id){
        if (!id.equals("None")) {
            Customers.add(id);
            System.out.println("Account "+id+" is successfully added! Welcome!");
        }
        else
            System.out.println("The user is not registered.");
    }
    static void printList(){
        System.out.println("Customer's List");
        for(int i = 0; i< Customers.size();i++){
            System.out.println((i+1)+") "+Customers.get(i));
        }
    }
   static boolean inList(String id){
       return Customers.contains(id);
   }

}

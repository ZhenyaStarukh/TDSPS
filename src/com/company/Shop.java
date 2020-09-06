package com.company;
import java.util.ArrayList;
//import java.util.Scanner;

public class Shop {
    private static final ArrayList<String> Customers = new ArrayList<>();
    private static ArrayList<Pigment> Pigments = new ArrayList<Pigment>();
    private static boolean open = true;
    private static double pillow;
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

   static boolean isOpen(){
        return open;
   }
   static void close(){
        open = false;
   }
   static void open(){ open = true;}
   static void printPigments(){
       System.out.println("List of pigments");
       for(int i = 0; i< Pigments.size();i++){
           System.out.println((i+1)+") "+Pigments.get(i).getName()+" "+Pigments.get(i).getPrice()+" "/*+Pigments.get(i).getFormula()*/);
       }
   }

}

package com.company;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private static final ArrayList<String> customers = new ArrayList<>();
    private static ArrayList<Pigment> pigments = new ArrayList<>();



    private static boolean open = true;
    private static double pillow = 20000;
    static void addCustomer(String id){
        if (!id.equals("None")) {
            customers.add(id);
            System.out.println("Account "+id+" is successfully added! Welcome!");
        }
        else
            System.out.println("The user is not registered.");
    }
    static void addPigment(Pigment pigment){
        Pigment addedPigment = null;
        try{
            addedPigment = (Pigment)pigment.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        pigments.add(addedPigment);
        System.out.println("Pigment "+addedPigment.getName()+" is successfully added!");
    }

    static Pigment getPigment(int index){
        Pigment pigment = null;
        try{
            pigment = (Pigment)pigments.get(index).clone();
        } catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return pigment;
    }

    static void printList(){
        System.out.println("Customer's List");
        for(int i = 0; i< customers.size();i++){
            System.out.println((i+1)+") "+customers.get(i));
        }
    }
   static boolean inList(String id){
       return customers.contains(id);
   }


   static void setPillow(double sum){
        pillow=sum;
   }

   static double getPillow(){return pillow;}

   static boolean isOpen(){
        return open;
   }
   static void close(){
        ExpensesService.addToPillow(Cashier.getCurrentBalance(),ExpensesService.buyPigments()+Cashier.getRent());
        Cashier.resetCurrentBalance();
        open = false;
   }
   static void open(){
       Pigment cyan = new Pigment(new double[]{1.0, 0.0, 0.0, 0.0, 0.0},"Cyan");
       Pigment magenta = new Pigment(new double[]{0.0, 1.0, 0.0, 0.0, 0.0},"Magenta");
       Pigment yellow = new Pigment(new double[]{0.0, 0.0, 1.0, 0.0, 0.0},"Yellow");
       Pigment black = new Pigment(new double[]{0.0, 0.0, 0.0, 1.0, 0.0},"Black");
       Pigment white = new Pigment(new double[]{0.0, 0.0, 0.0, 0.0, 1.0},"White");
       Pigment red = new Pigment(new double[]{0.0, 0.5, 0.5, 0.0, 0.0},"Red");
       Pigment blue = new Pigment(new double[]{0.5, 0.5, 0.0, 0.0, 0.0},"Blue");
       Pigment green = new Pigment(new double[]{0.5, 0.0, 0.5, 0.0, 0.0},"Green");
       Pigment purple = new Pigment(new double[]{0.34, 0.66, 0.0, 0.0, 0.0},"Purple");
       Pigment pink = new Pigment(new double[]{0.0,0.33,0.33,0.0,0.34},"Pink");
       pigments.add(cyan);pigments.add(magenta);pigments.add(yellow);pigments.add(black);
       pigments.add(white);pigments.add(red);pigments.add(blue);pigments.add(green);
       pigments.add(purple);pigments.add(pink);
        open = true;
        while(open){
            Client client = new Client();
            AvailabilityService.enterShop(client);
            Order order = new Order(client);
            Scanner in = new Scanner(System.in);
            String ans;
            do{
                System.out.println("Do you want to create your own pigment or choose from the list? Enter 'create' or 'choose'"+
                        "\nIf you're done with the order simply enter 'done'");
                ans = in.nextLine();
                switch (ans){
                    case "create":
                        order.createPigment();
                        break;
                    case "choose":
                        order.choosePigment();
                        break;
                    default:
                        System.out.println("Please enter again.");
                }
            }while(!ans.equals("done"));
            PurchaseService.Purchase(order);
            System.out.println("Do you want to close the shop?\ny-yes  n-no");
            ans = in.nextLine();
            if(ans.equals("y")) close();
        }
    }
   static void printPigments(Client client){
       DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        System.out.println("List of pigments");
        for(int i = 0; i< pigments.size();i++){
           if(pigments.get(i).getId().equals("None") || (inList(client.getId()) && pigments.get(i).getId().equals(client.getId())))
               System.out.println((i+1)+") "+pigments.get(i).getName()+"   "+decFormat.format(pigments.get(i).getPrice())
                       +" UAH   "+pigments.get(i).getFormula());

        }
   }

   static void deletePigments(Client client){
       DecimalFormat decFormat = new DecimalFormat("#,##0.00");
       System.out.println("List of your pigments");
       for(int i = 0; i< pigments.size();i++){
           if(inList(client.getId()) && pigments.get(i).getId().equals(client.getId()))
               System.out.println((i+1)+") "+pigments.get(i).getName()+"   "+decFormat.format(pigments.get(i).getPrice())
                       +" UAH   "+pigments.get(i).getFormula());

       }
       System.out.println("Enter the number of pigment you want to delete");
       Scanner in = new Scanner(System.in);
       int number = Integer.parseInt(in.nextLine())-1;
       System.out.println("Do you really want to delete pigment "+pigments.get(number).getName()+"?\ny-yes n-no");
       String ans = in.nextLine();
       if(ans.equals("y")) pigments.remove(number);
   }

}

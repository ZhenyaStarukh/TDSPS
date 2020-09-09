package com.company;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private  final ArrayList<String> customers = new ArrayList<>();
    private  final ArrayList<Pigment> pigments = new ArrayList<>();
    private  double pillow = 20000;
    private final ExpensesService expensesService;
    private final Cashier cashier;
    private final PurchaseService purchaseService;
    private final RegisterService registerService;


    public Shop(){
        //this part of the code is only used at this stage, because there is no db
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

        //this is only for showing the example
        customers.add("+380959873450");

        expensesService = new ExpensesService();
        cashier = new Cashier();
        purchaseService = new PurchaseService();
        registerService = new RegisterService();
    }

    void addCustomer(String id){
        if (!id.equals("None")) {
            customers.add(id);
            System.out.println("Account "+id+" is successfully added! Welcome!");
        }
        else
            System.out.println("The user is not registered.");
    }

    void addPigment(Pigment pigment){
        Pigment addedPigment = null;
        try{
            addedPigment = (Pigment)pigment.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        pigments.add(addedPigment);
        assert addedPigment != null;
        System.out.println("Pigment "+addedPigment.getName()+" is successfully added!");
    }

    Pigment getPigment(int index){
        Pigment pigment = null;
        try{
            pigment = (Pigment)pigments.get(index).clone();
        } catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return pigment;
    }

    void printCustomerList(){
        System.out.println("Customer's List");
        for(int i = 0; i< customers.size();i++){
            System.out.println((i+1)+") "+customers.get(i));
        }
    }

   boolean inList(String id){
       return customers.contains(id);
   }

   void setPillow(double sum){
        pillow=sum;
   }

   double getPillow(){return pillow;}

   void calculateIncome(){
        expensesService.addToPillow(cashier.getCurrentBalance(),expensesService.buyPigments(),this);
        cashier.resetCurrentBalance();
   }

    public void makePurchase(Order order,String ans){
        purchaseService.Purchase(order,ans,cashier);
    }

    void printPigments(Client client){
       DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        System.out.println("List of pigments");

        for(int i = 0; i< pigments.size();i++){
           if(pigments.get(i).getId().equals("None") || (inList(client.getId()) && pigments.get(i).getId().equals(client.getId())))
               System.out.println((i+1)+") "+pigments.get(i).getName()+"   "+decFormat.format(pigments.get(i).getPrice())
                       +" UAH   "+pigments.get(i).getFormula());

        }
   }

   void deletePigments(Client client, int index){
       printPigments(client);
       Scanner in = new Scanner(System.in);
       int number=index-1;

       while(number<10){
           System.out.println("Enter the number of pigment you want to delete.\nNOTE: you can only delete your custom pigments");
           number = Integer.parseInt(in.nextLine())-1;
       }
       pigments.remove(number);
   }

   void registerUser(Client client,String ans){
        registerService.Register(client,this,ans);
   }

}

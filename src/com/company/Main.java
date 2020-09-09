package com.company;


public class Main {

    public static void main(String[] args) {

        System.out.println("There is a pigment shop, where people can buy certain pigments for paint. " +
                "\nThe main idea of this project is to automate the process of purchasing from this shop.\n" +
                "Clients can create their own pigments by mixing basic pigments (cyan, magenta, yellow, black and white)" +
                " in the proportions given by them. The program will calculate the sum of those pigments, " +
                "automatically add money, gained from clients' orders, to shop's fund and calculate shop's income.\n\n\n");
        Shop shop = new Shop();



        System.out.println("Every shop has its customers.So let's create 3 of them: Ivan, Anna and Sasha.\n");
        Client Ivan = new Client();
        Client Anna = new Client();
        Client Sasha = new Client();



        System.out.println("In order to enter the shop's system, customers should enter their phone number. " +
                "\nThen they'll have an opportunity to register their number, or they can enter without registration.\n");

        Ivan.setId("+380959873450");
        Anna.setId("+380664521183");
        Sasha.setId("+380934568761");



        System.out.println("This shop gives some special benefits for those clients, who are registered in system, " +
                "\nlike ability to save your custom pigments in shop database and they have a discount." +
                "\nAnna decided to register her number.\n");
        shop.registerUser(Anna,"yes");
        shop.registerUser(Ivan,"yes"); //we'll see that Ivan's already registered
        shop.registerUser(Sasha,"no");




        System.out.println("\nLet's check what numbers are in client's list. You will see 2 numbers.\n It seems that " +
                "Ivan's number is already in list. He should be a regular customer.");
        shop.printCustomerList();



        System.out.println("It's turn for every client to make an order.\n");
        Order ivansOrder = new Order(Ivan);
        Order annasOrder = new Order(Anna);
        Order sashasOrder = new Order(Sasha);



        System.out.println("Every customer can choose one of shop's pigments or create their own. " +
                "List of pigments printed below\n");
        shop.printPigments(Sasha);//if customer is registered, they can see not only basic pigments, but also the one they've
        //saved before
        ivansOrder.choosePigment(shop,1000,7);
        ivansOrder.choosePigment(shop,500,5);
        annasOrder.createPigment(new double[]{0.0,0.34,0.66,0.0,0.0},1000);
        sashasOrder.createPigment(new double[]{0.1,0.3,0.5,0.1,0.0},140);
        sashasOrder.choosePigment(shop,590,4);



        System.out.println("\nCustomers, if they're authorized, can save their pigment.");
        System.out.println("Anna decided to save her custom pigment.\n");
        annasOrder.savePigment(1,shop,"Orange");



        System.out.println("We can check whether this pigment is saved. Let's check the list");
        System.out.println("Anna");
        shop.printPigments(Anna);
        System.out.println("\nIvan");
        shop.printPigments(Ivan);
        System.out.println("As you can see Ivan does not have the pigment, created by Anna\nBecause" +
                " only she can see pigments, created by her.\n");
        //you'll see that only Anna has additional pigment, 'cause she's the person, who created it.

        System.out.println("\nLet's try to save Sasha's pigment.");
        sashasOrder.savePigment(1,shop,"New color");
        System.out.println("\nAs we can see, unregistered customers can't save their pigments.");



        System.out.println("\nCustomer can delete their custom pigment.\nAnna decided that she'll delete her" +
                " custom pigment from shop's list (not from order!!!)");
        shop.deletePigments(Anna,11);
        System.out.println();
        //Checking whether this pigment was deleted
        shop.printPigments(Anna);



        System.out.println("\n\nCustomer can alter the formula of pigments, they've entered." +
                "\nFor example, Sasha decided to alter his first pigment in his order.");
        sashasOrder.alterPigmentFromOrder(1,new double[]{0.1,0.3,0.5,0.0,0.1});



        System.out.println("\nCustomer also can add effect to their pigments\nFirstly let's see what effects we can add.\n");
        for(Effect effect: Effect.values()) {
            System.out.println((effect.ordinal() + 1) + ") " + effect.getName() + ": " + effect.getPrice() + " UAH");
        }

        System.out.println("Ivan decided to add matte effect to his second pigment.\n");
        ivansOrder.addEffectForPigment(1, 3);

        System.out.println("\nIf customer changed their mind, they can remove certain pigment from his order\n");
        ivansOrder.removePigment(2);



        System.out.println("\nNow we can print out all orders.\n");
        System.out.println("Anna's \n"+annasOrder.toString());
        System.out.println("\n------------\nIvan's "+ivansOrder.toString());
        System.out.println("\n------------\nSasha's "+sashasOrder.toString());




        System.out.println("\n\nEvery customer can purchase their pigments. (or not)\n");
        System.out.println("Anna's ");
        shop.makePurchase(annasOrder,"yes");
        System.out.println("\n------------\nIvan's ");
        shop.makePurchase(ivansOrder,"no");
        System.out.println("\n------------\nSasha's ");
        shop.makePurchase(sashasOrder,"yes");



        System.out.println("\nAfter that we can calculate expenses and income.");
        shop.calculateIncome();

    }

}

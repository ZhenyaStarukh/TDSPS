package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pigment implements Cloneable{
    private double[] formula = new double[5];
    private double price;
    private String name;
    private double weight;
    private final Client client;
    private final ArrayList<String> effects = new ArrayList<>();


    public Pigment(double[] array, String name){  //for creating default pigments,probably won't be needed in future
        formula = array;
        this.name = name;
        pricePerGram();
        client = new Client();
    }

    public Pigment(Client client){
        createFormula();
        this.client = client;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getName() {
        if (name==null) return Arrays.toString(formula);
        return name;
    }

    public String getId(){
        return client.getId();
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){return weight;}

    public void savePigment(){
        if(!Shop.inList(client.getId())){
            System.out.println("Sorry! You should be registered in order to save pigments.");
            return;
        }

        System.out.println("Name your new pigment:");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();

        pricePerGram();

        Shop.addPigment(this);
    }

    //Effects--------------------------------------------------------------------------------------------------------
    public String getEffects(){
        return effects.toString();
    }

    public boolean haveEffects(){
        return !effects.isEmpty();
    }

    public void addEffect(){
        System.out.println("Choose from list below:");
        for(Effect effect: Effect.values()){
            System.out.println((effect.ordinal()+1)+") "+effect.getName()+": "+ effect.getPrice()+" UAH");
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number from 1 to 4:");
        int number = Integer.parseInt(in.nextLine());

        System.out.println("Are you sure you want to add "+Effect.values()[number-1].getName()+" to your pigment?" +
                "\ny-yes  n-no");
        String ans = in.nextLine();
        if(ans.equals("y")) {
            effects.add(Effect.values()[number-1].getName());
            System.out.println(Effect.values()[number-1].getName()+" added.");
        }
        else if (ans.equals("n"))
            System.out.println("No effect added.");


    }

    //Formula---------------------------------------------------------------------------------------------------------
    private double sumFormula(){
        double sum = 0.0;
        for (double v : formula) {
            sum += v;
        }
        return sum;
    }

    public void printFormula(){
        for (Color color: Color.values()){
            System.out.print(color.getName()+" ");
        }
        System.out.println();

        for (double v : formula) {
            System.out.print(v + "    ");
        }
        System.out.println();
    }

    private void createFormula(){
        Arrays.fill(formula, 0.0);
        System.out.println("For each color enter from 0(for 0%) to 1(for 100%) " +
                "to declare the percentage.\nBe aware that" +
                " the sum of all color percentage should be equal to 1 " +
                "(e.g. you can't have 100% of red and yellow" +
                " at the same time)");

        for(int i = 0;i<formula.length;i++){
            System.out.print(Color.values()[i].getName()+": ");
            Scanner in = new Scanner(System.in);
            double percent = Double.parseDouble(in.next());

            while(percent > 1 || percent < 0 || sumFormula()+percent>1){
                System.out.println("Please enter a number from 0 to 1.\n " +
                        "Remember that the total percentage sum should be <=1");
                percent = Double.parseDouble(in.next());
            }

            if(i==formula.length-1){
                while(sumFormula()+percent!=1){
                    System.out.println("Sum should be equal 1.");
                    percent = Double.parseDouble(in.next());
                }
            }

            formula[i]=percent;
        }

        pricePerGram();
    }

    public void alterFormula(){
        printFormula();
        createFormula();
    }

    public String getFormula(){
        String str = Arrays.toString(formula);
        if(!effects.isEmpty()) str += " "+effects.toString();
        return str;
    }

    public double getFormula(int index){
        return formula[index];
    }

    //Price------------------------------------------------------------------------------------------------------------
    public void pricePerGram(){
        price = 0.0;

        for(int i = 0;i<formula.length;i++){
            price+=Color.values()[i].getPrice()*formula[i];
        }

        for (String effect : effects) {
            price += Effect.valueOf(effect.toUpperCase()).getPrice();
        }
    }

    public double totalPrice(){
        pricePerGram();
        return price*weight;
    }

    public double getPrice(){return price;}
}

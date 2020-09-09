package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Order {
    private final ArrayList<Pigment> orderList = new ArrayList<>();
    private final Client client;
    private double totalPrice;
    public Order(Client client){
        this.client = client;
    }

    public void createPigment(double[] array, double weight){
        Pigment pigment = new Pigment(client,array);

        pigment.setWeight(weight);
        orderList.add(pigment);
    }

    public void choosePigment(Shop shop, double weight, int index){

        Pigment pigment = shop.getPigment(index-1);
        pigment.setWeight(weight);

        orderList.add(pigment);
    }

    public void alterPigmentFromOrder(int index, double[] array){
        orderList.get(index-1).alterFormula(array);
    }

    public void addEffectForPigment(int index, int effect){
        orderList.get(index-1).addEffect(effect);
    }

    public void savePigment(int index, Shop shop, String name){
        orderList.get(index-1).savePigment(shop,name);
    }

    @Override
    public String toString() {
        String order = "Order:\n";
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        for(int i = 0;i < orderList.size();i++){
            order += (i + 1)
                    +") "
                    +orderList.get(i).getName()+"  ";

            if(orderList.get(i).haveEffects())
                order += "("+orderList.get(i).getEffects()+")  ";

            order += decimalFormat.format(orderList.get(i).totalPrice())+" UAH    "
                    + decimalFormat.format(orderList.get(i).getWeight())+"g\n";
        }

        return order;

    }

    public void removePigment(int index){
            orderList.remove(index-1);
            System.out.println("Pigment is removed.");  //only for showing in the main
    }

    public double countPigment(int index){
        double count = 0.0;

        for (Pigment pigment : orderList) {
            count += pigment.getWeight() * pigment.getFormula(index);
        }
        return count;
    }

    public String getId(){return client.getId();}

    public void calculateTotalPrice(){
        totalPrice = 0.0;

        for (Pigment pigment : orderList) {
            totalPrice += pigment.totalPrice();
        }
    }
    public double getTotalPrice(){
        return totalPrice;
    }

    public void setDiscount(){
        totalPrice -= totalPrice*0.05;
        System.out.println("We have a discount 5% for registered customers!"); //only or showing in main
    }

    public void showTotal(){
        System.out.println(this.toString());
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println("___________________________________________");
        System.out.println("Total price:\t\t\t\t\t"+decimalFormat.format(totalPrice)+" UAH");
    }
}

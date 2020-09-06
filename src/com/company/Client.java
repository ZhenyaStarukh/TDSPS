package com.company;
import java.util.Scanner;

public class Client {
    private String id;
    public Client(){
        id = "None";
    }
    public String getId(){
        return id;
    }
    public void setId(String number){
        while(!number.matches("(\\+380)[3-9]\\d{8}")){
            System.out.println("Please try again.");
            Scanner in = new Scanner(System.in);
            number = in.next();
        }
        id = number;

    }
}

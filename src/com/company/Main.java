package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Client one = new Client();
    	Scanner in = new Scanner(System.in);
    	System.out.print("Enter phone number (e.g. +380976234532): ");
    	one.setId(in.next());
    	RegisterService.Register(one);
    	Client two = new Client();
    	RegisterService.Register(two);
    	RegisterService.Register(one);
    }
}

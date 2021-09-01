package com.mycompany.l8q6;

public class Burger {
    
    private String ID;
    private int numOfBurger;
    private static int total;
    
    public Burger(String ID,int sales){
        this.ID = ID;
        numOfBurger = sales;
        total += sales;
    }
    public void sold(int sales){
        numOfBurger += sales;
        total += sales;
    }
    public int track(){
        System.out.println("");
        System.out.print("Total Burger(s) : ");
        return total;
    }

    public  int getNumOfBurger() {
        return numOfBurger;
    }
}

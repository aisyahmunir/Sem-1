package com.mycompany.l8q6;

public class TestBurger {
    
    public static void main(String[] args) {
        
        Burger a = new Burger("UM001", 9);
        Burger b = new Burger("UM002", 5);
        Burger c = new Burger("UM003", 2);
       
        System.out.println(a.getNumOfBurger());
        System.out.println(b.getNumOfBurger());
        System.out.println(c.getNumOfBurger());
        System.out.println(b.track());
    }
}

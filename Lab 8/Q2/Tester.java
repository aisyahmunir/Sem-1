package com.mycompany.l8q2;

public class Tester {
 
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.setName("Nadia Lee");
        a.setIcNo("019910004554");
        a.setDeposit(1100);
        a.withdraw(50);
        a.add(120);
        System.out.println(a.toString());
        
    }  
}

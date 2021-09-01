package com.mycompany.l8q2;

public class BankAccount {
    
    private String name;
    private String icNo;
    private double deposit;
    
    // Create a new account
    public BankAccount(){
        
    }
    public BankAccount(String name, String ic, double amount){
        this.name = name;
        icNo = ic;
        deposit = amount;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    public void add(int amount){
        deposit += amount;
    }
    public void withdraw(int amount){
        if (amount > deposit) System.out.println("Not enough balance.");
        else deposit -= amount;
    }

    public double getBalance() {
        return deposit;
    }
    

    @Override
    public String toString() {
        String result = "Account Holder Name: " + name +"\nIC/Passport Number: "+ icNo + "\nBalance: "+deposit;
        return result;
    }
}

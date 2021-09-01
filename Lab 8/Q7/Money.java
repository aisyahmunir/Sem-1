package com.mycompany.l8q7;

public class Money {
    private double amount;
    private int[] notes = {100, 50, 10, 5, 1};
    private double[] coins = {.50, .20, .10, .5};
    
    public Money(){
        amount = 0;
    }
    public void modify(int[] note, int[] coin){
        for (int i = 0; i < note.length; i++) {
            amount += notes[i] * note[i];
        }
        for (int i = 0; i < coin.length; i++) {
            amount += coins[i] * coin[i];
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getBalance(){
        return amount;
    }
    public double getRoundOff(){
        double cents = amount - (int)amount; // 100.50 -> 0.50
        int temp = (int)(cents * 100); // 0.50 -> 50

        int digit = (int)temp % 10;
        if (digit <= 2){
            temp = temp/10 *10 + 0;
        }else if (digit >= 3 && digit <= 7){
            temp = temp/10 *10 + 5;
        }else{
            temp = (temp/10 + 1) * 10;
        }
        return (int)amount + (double)temp/100;
    }
    public double addition(Money b){
        return amount + b.amount;
    }
    public double subtraction(Money b){
        return amount - b.amount;
    }
}

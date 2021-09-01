package com.mycompany.l8q4;

public class Fraction {
    private int numerator;
    private int denominator;
    
    public Fraction(int x, int y){
        numerator = x;
        denominator = y;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    public int GCD(int x,int y){
        if (y==0)
            return x;
        while(y!=0){
            int temp =x;
            x=y;
            y=temp%y;
        }
        return x;
    }
    public String reduced(){
        int gcd = GCD(denominator,numerator);
        return numerator/gcd + "/" + denominator/gcd;
    }
}

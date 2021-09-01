package com.mycompany.l8q3;

public class TestWeight {
    
    public static void main(String[] args) {
        
        WeightCalculator w = new WeightCalculator();
        w.setAge(20);
        w.setHeight(161);
        System.out.println(w.toString());
    }
}

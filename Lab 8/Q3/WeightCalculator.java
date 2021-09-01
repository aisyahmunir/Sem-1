package com.mycompany.l8q3;

public class WeightCalculator {
    
    private int age;
    private int height;
    private double recommendedWeight;
    
    // Create new weightcalculator
    public WeightCalculator(){
        
    }
    public WeightCalculator(int age, int height){
        this.age = age;
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public double calculate(){
        recommendedWeight = (height-100+age/10)*0.9;
        return recommendedWeight;
    }

    @Override
    public String toString() {
        return "Age: "+age+"\nHeight: "+height+"\nRecommended Weight: "+calculate();   
    }    
}

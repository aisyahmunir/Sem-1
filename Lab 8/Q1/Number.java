package com.mycompany.l8q1;

import java.util.Random;

public class Number {
    
    private int[] num;
    private Random r = new Random();
    
    public Number(){
        num = new int[10];
        for (int i=0;i<num.length;i++){
            num[i] = r.nextInt(101);
        }
    }
    public Number(int size){
        num = new int[size];
        for (int i=0;i<num.length;i++){
            num[i] = r.nextInt(101);
        }
    }
    public Number(int size,int max){
        num = new int[size];
        for (int i=0;i<num.length;i++){
            num[i] = r.nextInt(max+1);
        }
    }
    public String even() {
        String str = "";
        for(int i=0; i<num.length; i++) {
            if (num[i]%2==0) {
                str += num[i] + " ";
            }
        }        
        return str;    
    }
    @Override
    public String toString() {
        String str = "";
        for(int i=0; i<num.length; i++) {
            str = str + num[i] + " ";
        }        
        return str;
    }
    public String prime(){
        String result ="";
        for (int i=0;i<num.length;i++){
            boolean isPrime = true;
            for (int k=2;k<=num[i]/2;k++){
                if (num[i]%k == 0){
                    isPrime = false;
                    break;
                }
            }
            if(num[i]==1 || num[i] == 0)
                isPrime = false;
            if (isPrime)
                result += num[i] + " ";
        }
        return result;
    }
    public int max(){
        int max =num[0];
        for (int i=1;i<num.length;i++){
            if (num[i]>max)
                max = num[i];
        }
        return max;
    }
    public int min(){
        int min =num[0];
        for (int i=1;i<num.length;i++){
            if (num[i]<min)
                min = num[i];
        }
        return min;
    }
    public int average(){
        int sum =0;
        for (int i=1;i<num.length;i++){
            sum += num[i];
        }
        int avg = sum/num.length;
        return avg;
    }
    public String square() {
        String str = "";
        for(int i=0; i<num.length; i++) {
            str += num[i]*num[i] + " ";
        }        
        return str;    
    }
}
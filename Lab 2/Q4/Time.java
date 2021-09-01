package Q4;

import java.util.Scanner;

public class Time{
    
    public static void main(String[] args) {
   
        Scanner second = new Scanner(System.in);
        
        System.out.println("Enter your time (s) : ");
        int s;
        s= second.nextInt();
        
        int hour;
        int min;
        int sec;
        
        sec = s%60;
        hour = s/60;
        min = hour%60;
        
        hour = hour/60;
        
        System.out.print(s);
        System.out.print(" seconds is ");
        System.out.print(hour+ " hours ");
        System.out.print(min+ " minutes ");
        System.out.println(sec+ " seconds");
        
    } 
}


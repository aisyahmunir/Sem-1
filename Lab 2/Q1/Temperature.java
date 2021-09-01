package Q1;

import java.util.Scanner;

public class Temperature {
    
    public static void main(String[] args) {
        
        System.out.println("Hi, welcome ;)");
       
        Scanner tem = new Scanner(System.in);
        double num;
        
        System.out.println("Enter your temperature (F): ");
        
        num=tem.nextDouble();
        double cel;
        
        cel = (num-32)/1.8;
         
        System.out.printf("Your temperature in Celcius is %6.2f ", cel); 
    }
    
}

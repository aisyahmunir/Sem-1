package Q3;


import java.util.Random;


public class Time {
    
    public static void main(String[] args) {
        
        int num; 
        int num2; 
        int num3;
        float sum;
        float average;
        //sum and average can also be in double form 
        
        Random nom = new Random();
        num = nom.nextInt(41)+10;
        num2 = nom.nextInt(41)+10;
        num3 = nom.nextInt(41)+10;
        
        sum = num + num2 + num3 ;
        average = sum/3;
        
                
        System.out.print("Your number is " +num);
        System.out.print(", "+num2);
        System.out.println(" and "+num3);
        
        System.out.println("Total of numbers : " + sum);
        System.out.print("Average of numbers : ");
        System.out.printf("%6.2f", average);
          
    }
}


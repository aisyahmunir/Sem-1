package Q5;


import java.util.Random;


public class SumOfDigit {
    
    public static void main(String[] args) {
        
        Random N = new Random();
        
        int num = N.nextInt(10001);
        System.out.println("Random number : " +num);
        int sum = 0;
        
        while (num != 0){
            
            sum = sum + num % 10 ;
            num /= 10;
            
        }
        
        
        System.out.println("Sum of all digits in the number : " +sum);
        
    }
}


package Q4;

import java.util.Scanner;

public class GCDNum {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your first integer : ");
        int num1 = s.nextInt();
        System.out.println("Enter your second integer : ");
        int num2 = s.nextInt();
        
        System.out.println("GCD for these two integers is " +num1+ " and " 
                +num2+ " is " + greatest(num1, num2));
        
        /* System.out.println(gcd(24,8));
        System.out.println(gcd(200,625)); */    //cara lainn tk yh get input
    }
    
    public static int greatest(int num1, int num2) {
        if (num2 == 0 ) {
            return num1;
        }
        return greatest(num2, num1%num2);
    }
    
    /* public static int gcd( int a, int b){    //guna while loop
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;   */
}

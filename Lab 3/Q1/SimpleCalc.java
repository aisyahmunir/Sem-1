package Q1;

import java.util.Scanner;

import java.util.Scanner;

public class SimpleCalc {
    
        public static void main(String[] args) {
        
        
        System.out.println("Hello buddy ;)");
        System.out.println("I can help you with Maths");
        
        int num1,num2,ans = 0 ;
                
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter two integer number : ");
        num1 = s.nextInt() ;
        num2 = s.nextInt();
        
        System.out.println("Enter the operand (+ , -, *, /, %) : ");
        String temp = s.next();
        char a = temp.charAt(0) ;
        
        switch (a) {
            case '+' :
                ans = num1 + num2;
                break;
            case '-' :
                ans = num1 - num2;
                break;
            case '*' :
                ans = num1 * num2;
                break;
            case '/' :
                ans = num1 / num2;
                break;
            case '%' :
                ans = num1 % num2;
                break;
        }
        System.out.println(num1+ " " + a + " " +num2+ " = " +ans);
    }

}


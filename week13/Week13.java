
package week13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week13 {

    public static void main(String[] args) {
        //System.out.println("Testing");
        /*
        Scanner s = new Scanner(System.in);
        // try-catch-finally statement 
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter a number : ");
                int num = s.nextInt();
                valid = true;
                System.out.println("The number is " + num);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, you should enter an integer");
                s.nextLine();
            } finally {
                // System.out.println("To close file or database connection");
            }
        }
      
        // define the condition to throw exception
        int numOfStudent = 50;
        try {
            if (numOfStudent > 60) {
                throw new Exception("We need three extra classess");
            }
            else if (numOfStudent > 30) {
                throw new Exception("We need two extra classess");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            int num1=4, num2=0;
            System.out.println(special(num1, num2));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        */ 
        
        // define exception class
        try {
            int mark = 94; 
            if (mark<50) {
                throw new FoPException();
            }
            else if (mark >=90) {
                throw new FoPException("Please work harder for Final");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    // exception in Method  
    public static int special(int a, int b) throws ArithmeticException {
        return a/b;
    }

}

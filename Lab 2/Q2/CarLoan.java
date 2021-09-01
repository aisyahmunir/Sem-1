package Q2;


import java.util.Scanner;


public class CarLoan {
    
    public static void main(String[] args) {
        
        Scanner price = new Scanner(System.in);
        float P;
        
        System.out.println("Enter car price : ");
        P = price.nextFloat();
        
        Scanner  downp = new Scanner(System.in);
        float D;
        
        System.out.println("Enter down payment : ");
        D = downp.nextFloat();
        
        Scanner interest = new Scanner(System.in);
        float R;
        
        System.out.println("Enter interest rate (%) : ");
        R = interest.nextFloat();
        
        Scanner loan = new Scanner(System.in);
        float Y;
        
        System.out.println("Enter loan duration (year): ");
        Y = loan.nextFloat();
        
        float M;
        //you can also replace float with double
        
        M = (P-D)*(1+R*Y/100)/(Y*12);
        
        System.out.print("Total Monthly Payment : RM");
        System.out.printf("%6.2f",M);
        
    }
}


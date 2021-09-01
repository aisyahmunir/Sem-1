package Q7;

import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter principal number : ");
        int principal = s.nextInt();
        System.out.println("Enter interest (%) : ");
        double rate = s.nextDouble();
        System.out.println("Enter total nmuber of month(s) : ");
        int month = s.nextInt();
        
        double monthlyPayment = (principal * rate / (12*100)) / 
                (1- Math.pow(1 + rate/(12*100), -month)) ;
        System.out.println(" ");
        
        System.out.printf("%s\t%20s\t%14s\t%13s\t%19s\t%19s"
                ,"Month","Monthly Payment","Principal", "Interest"
                , "Unpaid Balance", "Total Interest\n" );
        
        int currentMonth = 1;
        double Interest = 0;
        while (currentMonth <= month){
            double principalPortionDue = monthlyPayment *
                    Math.pow(1 + rate/(12*100), -(1 + month - currentMonth));
            double interestDue = monthlyPayment - principalPortionDue;
            double unpaidBalance = interestDue / (rate / (12*100))- principalPortionDue;
                                    Interest += interestDue;
            Interest += interestDue;
            
            System.out.printf("%d\t%20.2f\t%14.2f\t%13.2f\t%19.2f\t%19.2f\n", currentMonth
                , monthlyPayment, principalPortionDue, interestDue
                , unpaidBalance, Interest);
        currentMonth++ ;
        }
        
    }
}

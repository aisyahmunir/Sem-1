package Q3;

import java.util.Scanner;

public class SaleVolume {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sales : ");
        double sale = s.nextDouble();
   
        double percent = 0; 
        double commision ;
        
        if (sale <= 100) {
            percent = 5 ;
        }
        else if ( sale > 100 && sale <= 500) {
            percent = 7.5 ;
        }
        else if (sale > 500 && sale <= 1000) {
            percent = 10 ;
        }
        else {
            percent = 12.5 ;
        }
        
        commision = sale * percent / 100 ;
        System.out.printf("The commision is %.2f\n", commision);
    }
}

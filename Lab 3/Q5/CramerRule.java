package Q5;

import java.util.Scanner;

public class CramerRule {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter value for 'a' : ");
        int a = s.nextInt();
        
        System.out.println("Enter value for 'b' : ");
        int b = s.nextInt();
        
        System.out.println("Enter value for 'c' : ");
        int c = s.nextInt();
        
        System.out.println("Enter value for 'd' : ");
        int d = s.nextInt();
        
        System.out.println("Enter value for 'e' : ");
        int e = s.nextInt();
        
        System.out.println("Enter value for 'f' : ");
        int f = s.nextInt();
        
        if ( ( (a*d) - (b*c) ) == 0) {
            System.out.println(" The equation has no solution.");
        }
        else {
            double x = (double) (e*d - b*f ) / ( (a*d) - (b*c) ) ;
            double y = (double) ((a*f - e*c) / (a*d - b*c)) ;
            
            System.out.println("The value for x is " +x);
            System.out.println("The value for y is " +y);
        }
    }
}


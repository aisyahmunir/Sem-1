package Q6;

import java.util.Scanner;

public class Circle {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the radius (cm) : ");
        double radius = s.nextDouble();
        
        System.out.println("Enter value for 'x' : ");
        int x = s.nextInt();
        
        System.out.println("Enter value for 'y' : ");
        int y = s.nextInt();
        
        System.out.println(" ");
        
        double distance = Math.sqrt(Math.pow(x,2) + y*y);
        if (distance <=radius){
            System.out.printf("The point (%d,%d) is inside the circle.", x, y);
        }
        else{
            System.out.printf("The point (%d,%d) is outside the circle.", x,y);
        }
    }
}

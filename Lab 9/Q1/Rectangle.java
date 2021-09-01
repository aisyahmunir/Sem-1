package Q1;

import java.util.Scanner;

public class Rectangle extends Shape {
    private double length,width;
    
    public Rectangle (){
        super("Rectangle");
        
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the length: ");
        length = s.nextDouble();
        System.out.print("Enter the width: ");
        width = s.nextDouble();
    }
    public void calculate(){
        perimeter = 2*(length+width);
        area = length*width;
    }
    
}
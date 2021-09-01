package Q1;

import java.util.Scanner;

public class Square extends Shape{
    private double length;
    
    public Square(){
        super("Square");
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the length: ");
        length = s.nextDouble();       
    }
    public void calculate(){
        perimeter = 4*length;
        area = length*length;
    }
    
}

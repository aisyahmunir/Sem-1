package Q1;

import java.util.Scanner;

public class Circle extends Shape{
    private double diameter;
    
    public Circle(){
        super("Circle");
    }
    public void input(){
        Scanner  s = new Scanner(System.in);
        System.out.print("Enter the diameter for circle: ");
        diameter = s.nextDouble();
        
    }
    public void calculate(){
        perimeter = 2*Math.PI*diameter/2;
        area = Math.PI*(diameter/2)*(diameter/2);
    }
}

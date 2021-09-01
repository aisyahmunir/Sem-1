package week12;

public class Week12 {

    public static void main(String[] args) {
        // System.out.println("Testing");
        /*
        // abstract class
        Car a = new Car();
        Boat b = new Boat();
        testing(a);
        testing(b);
        
        Vehicle d = a;
        d.special();
        d = b;
        d.special();
        */
        
       /*
       // interface
       int X=5, Y=10;
       Square s  = new Square(X);
       Cube c = new Cube(X);
       info(s);
       info(c);
       Square t  = new Square(Y);
       if (s.compareTo(t)>0) {
           System.out.println("Object s is bigger");
       }
       else
           System.out.println("Object t is bigger");
       */
       //Create an Employee Salary System. 
       //The system will display the employee name, employee type and total salary 
       //per month. 
       // A permanent employee is divided into three categories. 
       // A is 4000, B is 3000 and C is 2000. 
       // A contract staff has a fixed monthly income of 500 
       // and a commission of 50% of the total sales. 
       // A temporary staff is given 15 per hour work. 
       // Create one abstract base class and three derived class for the system.
       // Create a Tester class to test the program.
       
       Permanent p1 = new Permanent("B");
       Contract p2 = new Contract(400.25);
       Temporary p3 = new Temporary(400);
       print(p1);
       print(p2);
       print(p3);
    }
    public static void print(ESS a) {
        System.out.println(a.toString());
    }
    
    
    public static void info(Number a) {
        System.out.println(a.toString());
    }
        
    public static void testing(Vehicle a) {
        a.special();
        System.out.println("The number is " + a.getRandom(5));
    }
    /*
    public static void testing(Car a) {
        a.special();
    }
    
    public static void testing(Boat a) {
        a.special();
    }
    */
    
}

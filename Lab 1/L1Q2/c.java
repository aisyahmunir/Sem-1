
package L1Q2;

import java.util.Scanner;

public class c {
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        
        System.out.println("Capacity ");
        String s = in.next();
        int a = in.nextInt();
        System.out.print("You entered integer " + a);
       
          // closing scanner
          in.close();
    }
}

package Q5;

import java.util.Random;
import java.util.Scanner;

public class MultiNum {
    
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int score = 0;
        
        while(true){
            System.out.println("Enter negative number to quit.");
            int a = r.nextInt(13);
            int b = r.nextInt(13);
            System.out.printf("%d x %d = \n", a, b);
            int guess = s.nextInt();
            if (guess < 0) break;
            if (check(a,b,guess)) score++;
        }
        System.out.println("Your score is " + score);
        
    }
    public static boolean check(int a, int b, int c){
        return a*b == c;
    }
}
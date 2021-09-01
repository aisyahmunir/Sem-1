package Q3;

import java.util.Scanner;

public class Deviation {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int sum = 0, sumSqr = 0, n = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        while(true){
            System.out.println("Enter a score [negative score to quit]: ");
            int num = s.nextInt();
            if (num < 0) break;
            n++;
            sum += num;
            sumSqr += num*num;           
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        double avg = (double) sum / n ;
        double sd = Math.sqrt((sumSqr - (sum*sum) / n ) / (n-1)) ;
        System.out.println("Minimum score: " + min);
        System.out.println("Maximum score: " + max);
        System.out.printf("Average score: %.2f\n", avg);
        System.out.printf("Standard Deviation: %.2f\n", sd);
        
    }
}
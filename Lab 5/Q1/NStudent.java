
package Q1;

import java.util.Random;
import java.util.Scanner;

public class NStudent {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random r = new  Random();
        
        System.out.println("Enter value of N : ");
        int n = s.nextInt();
        
        int student[] = new int[n];
        int highest = 0, lowest = 100;
        double avg = 0;
        int sum = 0;
        
        for (int i=0; i<n; i++) {
            student[i] = r.nextInt(101);
            highest = Math.max(highest, student[i]);
            lowest = Math.min(lowest, student[i]);
            sum += student[i];
        }
        
        avg = (double) sum / n;
        System.out.println("The list of scores : ");
        
        for (int score : student){
            System.out.print(score + " ");
        }
        System.out.println(" ");
        System.out.println("Lowest score : " + lowest);
        System.out.println("Highest score :  " + highest);
        System.out.printf("Average score : %.2f", avg);
    }
    
}

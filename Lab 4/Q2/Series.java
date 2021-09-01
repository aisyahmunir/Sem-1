package Q2;

import java.util.Scanner;

public class Series {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        int num = s.nextInt();
        
        int sum = 0;
        int prefix = 0;

        for(int i=1; i<=num; i++){ 
            prefix += i;
            System.out.print(prefix + " ");
            sum += prefix;
        }
        System.out.println(" ");
        System.out.println("Sum of series : "+sum);
        
    }
}
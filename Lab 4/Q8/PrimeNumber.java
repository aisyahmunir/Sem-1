package Q8;

import java.util.Random;

public class PrimeNumber {
    public static void main(String[] args) {
        
        Random r = new Random();
        int num = r.nextInt(101);
        int count = 0;
        
        System.out.print("The first " + num + " prime number are ");
        // 1 not prime number
        for (int i = 2; i <= Integer.MAX_VALUE; i++) {
            if (count == num) break;
            if (i == 2 || i == 3 || i == 5 || i == 7) {
                System.out.print(i + " ");
                count++ ;
            }
            else {
                if ( i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0){
                    System.out.print(i + " ");
                    count++;
                }
            }
        }
        System.out.println(" ");
    }
}

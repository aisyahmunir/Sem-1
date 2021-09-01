package Q6;

import java.util.Random;

public class NonNegative {
    
    public static void main(String[] args) {
        
        Random r = new Random();
        int num = r.nextInt();
        System.out.println("The random number is " + num);
        
        int count = 0;
        if (num == 0) count = 1;
        else{
            while (num > 0){
                num /= 10;
                count++;
            }
        }
        System.out.println("Number of digits : " + count);
    }
}

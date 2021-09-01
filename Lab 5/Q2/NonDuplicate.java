package Q2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NonDuplicate {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        int[] arr = new int[10];
        boolean[] taken = new boolean[21];
                
        int i = 0;
        while(i < 10){
            int num = r.nextInt(21);
            if (taken[num] == true) continue;
            
            taken[num] = true;
            arr[i++] = num;
        }
        
        System.out.println(Arrays.toString(arr));
        
        }
}

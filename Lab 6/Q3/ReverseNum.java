package Q3;

import java.util.Random;

public class ReverseNum {
    
    public static void main(String[] args) {
        
        Random r = new Random();
        
        int[] array = new int[10];
        System.out.println("Your list of number is : ");
        for(int i = 0; i<array.length; i++){
            array[i]= r.nextInt(1001);
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        
        System.out.println("Reverse array : ");
        reverse(array);
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void reverse(int[] array){

        for (int i =0; i<array.length; i++){
            int rev = 0;
            while(array[i] > 0){
               rev = rev * 10 + array[i] % 10;
               array[i] /= 10;
        }
            array[i] = rev;
    }
    }
}

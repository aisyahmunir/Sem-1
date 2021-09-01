package Q2;

import java.util.Random;
import java.util.Scanner;

public class IntWord {
    
    public static void main(String[] args) {
      
        Scanner s = new Scanner(System.in);
        Random n = new Random();
        int num = n.nextInt(6); // 0 - 5
        
        switch(num){
            case 0 :
                System.out.println(num + " is zero.");
                break;
            case 1 :
                System.out.println(num + " is one.");
                break;
            case 2 :
                System.out.println(num + " is two.");
                break;
            case 3 :
                System.out.println(num + " is three.");
                break;
            case 4 :
                System.out.println(num + " is four.");
                break;
            case 5 :
                System.out.println(num + " is five.");
                break;
        }
    }
}
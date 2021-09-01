package Q1;

import java.util.Scanner;

public class Integer {
    
        public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer : ");
        int num = s.nextInt();
        
        System.out.print("The factors are ");
        
        for(int i=1; i<num; i++){
            if (num % i == 0){
                System.out.print(i + ", ");
            }
        }
        System.out.println(num);
    }
}


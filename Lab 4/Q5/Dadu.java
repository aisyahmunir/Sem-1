package Q5;

import java.util.Random;
import java.util.Scanner;

public class Dadu {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        final int MAX = 6;
        int player1 = 0, player2 = 0;
        int turns = r.nextInt(2); 
        
        while (true){
            int num = r.nextInt(MAX) + 1 ; // 1- 6
            if( turns % 2 == 0) {   // even, player1
                player1 += num;
                System.out.println("Player 1 got " + num );
                while(num == 6){
                    num = r.nextInt(MAX) + 1;
                    System.out.println("Player 1 got " + num );
                    player1 += num;
                }
            } else {               // odd, player2
                player2 += num;
                System.out.println("Player 2 got " + num );
                while(num == 6){
                    num = r.nextInt(MAX) + 1;
                    System.out.println("Player 2 got " + num );
                    player2 += num;
                }       
            }
            turns++;
            if (player1 > 100 || player2 > 100) break;
        }
        if ( player1 > player2) System.out.println("\nPlayer 1 Win");
        else System.out.println("\nPlayer 2 Win");
    }
}

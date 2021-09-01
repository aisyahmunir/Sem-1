package Q4;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random d = new Random();
        
        int player1turn1 = d.nextInt(6) + 1 ;
        int player1turn2 = d.nextInt(6) + 1 ;
        int player2turn1 = d.nextInt(6) + 1 ;
        int player2turn2 = d.nextInt(6) + 1 ;
        
        int score1 = player1turn1 + player1turn2 ;
        int score2 = player2turn1 + player2turn2 ;
        
        System.out.println("Player 1 : " +player1turn1 + " + " +player1turn2 + " = " + score1);
        System.out.println("Player 2 : " +player2turn1 + " + " +player2turn2 + " = " + score2);
        System.out.println(" ");
        
        if (score1 > score2)
            System.out.println("PLAYER 1 WIN !!");
        else if (score2 > score1)
            System.out.println("PLAYER 2 WIN !!");
        else
            System.out.println("It's a TIE. ");

    }
}


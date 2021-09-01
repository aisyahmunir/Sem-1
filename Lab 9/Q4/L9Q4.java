package com.mycompany.l9q4;

public class L9Q4 {

    public static void main(String[] args) {
        Game1 player1Game1 = new Game1();
        Game1 player2Game1 = new Game1();
        
        System.out.println("Game 1");
        while(player1Game1.score < 100 && player2Game1.score < 100){
            player1Game1.play();
            System.out.println("Player 1 Total : " + player1Game1.score);
            player2Game1.play();
            System.out.println("Player 2 Total : " + player2Game1.score);
        }
        if (player1Game1.score > player2Game1.score) System.out.println("Player 1 Wins");
        else System.out.println("Player 2 Wins");
        
        
        Game2 player1Game2 = new Game2();
        Game2 player2Game2 = new Game2();
        
        System.out.println("Game 2");
        while(player1Game2.score != 100 && player2Game2.score != 100){
            player1Game2.play();
            System.out.println("Player 1 Total: " + player1Game2.score);
            player2Game2.play();
            System.out.println("Player 2 Total: " + player2Game2.score);
        }
        if (player1Game2.score == 100) System.out.println("Player 1 wins");
        else System.out.println("Player 2 wins");
    }
    
}

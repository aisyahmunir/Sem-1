package com.mycompany.l8q5;

import java.util.Random;

public class Game {
    private Random r = new Random();
    private int score1, score2, dice;
    private String name1, name2;

    public Game(String player1, String player2) {
        name1 = player1;
        name2 = player2;
    }

    public void move() {
        int sequence = r.nextInt(2);
        while (score1 < 100 && score2 < 100) {
            if (sequence %2 == 0) { //Player1 Start first if get zero
                dice = r.nextInt(6) + 1;
                System.out.println(name1+" gets " + dice);
                score1 += dice;           
            } else {
                dice = r.nextInt(6) + 1;
                System.out.println(name2+" gets " + dice);
                score2 += dice;                
            }
            sequence++;

        }
        if (score1>=100){
            System.out.println("");
            System.out.println(name1+ " win!");
        }
        else{
            System.out.println("");
            System.out.println(name2+ " win!");
        }
    }
}

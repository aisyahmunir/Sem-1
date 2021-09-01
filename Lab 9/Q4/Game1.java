package com.mycompany.l9q4;

public class Game1 extends DiceGame{
    private int dice1, dice2;
    
    public Game1(){
        super();
        dice1 = 0;
        dice2 = 0;
    }
    
    public void play(){
        do{
            dice1 = r.nextInt(6) + 1;
            dice2 = r.nextInt(6) + 1;
            score += dice1 + dice2;
        }while(dice1 == dice2);
    }
}

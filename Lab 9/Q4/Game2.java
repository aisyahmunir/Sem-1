
package com.mycompany.l9q4;

public class Game2 extends DiceGame{
    private int dice;
    
    public Game2(){
        super();
        dice = 0;
    }
    
    public void play(){
        dice = r.nextInt(6) + 1;
        score += dice;
        if (score > 100) score -= dice;
        
        if (dice == 6){
            dice = r.nextInt(6) + 1;
            if (dice != 6) score += dice;
            if (score > 100) score -= dice;
        }
    }
}


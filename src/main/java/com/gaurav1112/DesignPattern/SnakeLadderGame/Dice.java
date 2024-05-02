package com.gaurav1112.DesignPattern.SnakeLadderGame;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int diceNow = 0;
        int total = 0;

        while (diceNow < diceCount){
            total += ThreadLocalRandom.current().nextInt(min, max+1);
            diceNow++;
        }
        return total;
    }
}

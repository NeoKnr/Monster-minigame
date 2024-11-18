package fr.estiam.fabien.models;

import java.util.Random;

public class Dice {
    public int rollingDice(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }
}

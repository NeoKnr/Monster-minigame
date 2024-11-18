package fr.estiam.fabien.models;

import java.util.concurrent.TimeUnit;

public class MonsterLv1 {
    int damage = 5;
    boolean alive = true;

    Dice deMonstre = new Dice();


    public boolean isAlive(){
        return alive;
    }

    public void getDammaged() {
        alive = false;
    }

    public int throwingDice() {
        return deMonstre.rollingDice();
    }


    public void attack(Player player) {
        int playerDice = player.rollingDice();
        int monsterDice = throwingDice();
        if (monsterDice > playerDice) {
            System.out.printf("Lancé du dé du joueur : %d, Lancé du dé du monstre : %d \n", playerDice, monsterDice);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Le monstre attaque.");
            player.getAttacked(damage);
            player.isAlive();
        } else {
            System.out.printf("Lancé du dé du joueur : %d, Lancé du dé du monstre : %d \n", playerDice, monsterDice);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Le monstre n'attaque pas.");

        }

    }

}

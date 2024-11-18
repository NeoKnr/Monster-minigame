package fr.estiam.fabien.models;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Player {
    private int hp = 100;
    private String name;
    boolean alive = true;
    Dice deJoueur = new Dice();


    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }
    public boolean isAlive() {
        if (hp > 0) {
                return alive;
        }
        else {
                alive = false;
                return alive;
        }
    }
    public int getAttacked(int damage) {
        shield(damage);
        return hp;
    }
    public int rollingDice() {
        return deJoueur.rollingDice();
    }
    public void attack(MonsterLv1 monster) {
        int playerDice = rollingDice();
        int monsterDice = monster.throwingDice();
        if (playerDice >=  monsterDice) {
                System.out.printf("Lancé du dé du joueur : %d, Lancé du dé du monstre : %d \n", playerDice, monsterDice);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Le joueur attaque !");
                monster.getDammaged();
        }
        else {
                System.out.printf("Lancé du dé du joueur : %d, Lancé du dé du monstre : %d \n", playerDice, monsterDice);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName() + " n'attaque pas.");

        }
    }
    public int shield(int damage) {
        Random random = new Random();
        int resultat = random.nextInt(6)+1;
        if (resultat<=2) {
            System.out.println("Lancé de dé " + getName() +" : " + resultat);
            System.out.println("Le bouclier de "+ getName() + " s'est activé, il ne reçoit pas les dégâts");
            return hp;
        }
        else {
            System.out.println("Lancé de dé de " + getName() +" : " + resultat);
            System.out.println("Le bouclier de " + getName() + " ne s'est pas activé, "+ getName() +" reçoit " + damage + " points de dégâts.");
            hp -= damage;
            return hp;
        }
    }

}
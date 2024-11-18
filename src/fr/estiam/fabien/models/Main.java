package fr.estiam.fabien.models;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        MonsterLv1 monster;

        int score = 0, nbMortsLvl1 = 0, nbMortsLvl2 = 0;

        Player Player = new Player();
        System.out.print("Quel est votre nom ? ");
        Player.setName(sc.nextLine());

        int nivMonstre;
        int lanceDe;

        while (Player.isAlive()) {
            lanceDe = random.nextInt(2) + 1;
            nivMonstre = lanceDe;

            if (lanceDe == 1) {
                monster = new MonsterLv1();
            } else {
                monster = new MonsterLv2();

            }
            
            System.out.printf("--------------- Un monstre niveau %d apparaît ! ---------------\n", nivMonstre);
            while (monster.isAlive()) {
                if (Player.isAlive()) {
                    System.out.printf(Player.getName() + " est toujours vivant et il lui reste %d point(s) de vie.\n", Player.getHp());
                    Player.attack(monster);
                    if (monster.isAlive()) {
                        monster.attack(Player);
                    }
                    else {
                        if (monster instanceof MonsterLv2) {
                            score += 2;
                            nbMortsLvl2++;
                            System.out.println("Le monstre de niveau 2 est mort, vous gagnez 2 points.");
                            break;

                        } else {
                            score++;
                            nbMortsLvl1++;
                            System.out.println("Le monstre de niveau 1 est mort, vous gagnez 1 point.");
                            break;

                        }
                    }
                } else {
                    System.out.println(Player.getName() + " est mort. Fin de la partie.");
                    break;
                }

            }
        }
        System.out.println(nbMortsLvl1 + " monstres niveau 1 ont été tués, " + nbMortsLvl2 + " monstres niveau 2 ont été tués.");
        System.out.println("Votre score est de : " + score + "\n("+ nbMortsLvl1 +" + "+nbMortsLvl2 +" x 2)");
    }
}

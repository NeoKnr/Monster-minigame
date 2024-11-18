package fr.estiam.fabien.models;

public class MonsterLv2 extends MonsterLv1 {
    Dice deJoueur = new Dice();

    @Override
    public void attack(Player player) {
        super.attack(player);
        int res = deJoueur.rollingDice();
        if (res !=6) {
            System.out.println("Lancé de dé du monstre: " + res);
            System.out.println("Le monstre lance son attaque magique.");
            res = res*5;
            player.getAttacked(res);
            player.isAlive();
        }
        else {
            System.out.println("Lancé du dé du monstre : " + res);
            System.out.println("L'attaque magique a échouée.");
        }
    }
}

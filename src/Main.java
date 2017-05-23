import MC.*;
import View.Fenetre;

public class Main {
    public static void main (String[] args){

        Fenetre f = new Fenetre(1100, 800, "Jeux");

        Abalone AB = new Abalone();
        DameChinoise dm = new DameChinoise(2);
        f.setJeu(dm);
        f.setJeu(AB);

        // TESTS //
        /*
        AB.getPlateau().affichePlateau();
        AB.jouerCoup('H',47);
        System.out.println();
        AB.getPlateau().affichePlateau();
        */
    }
}

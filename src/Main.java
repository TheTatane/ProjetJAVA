import MC.*;
import View.Fenetre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main (String[] args){

        Fenetre f = new Fenetre(1100, 800, "Jeux");

        ////// ABALONE
        Abalone AB = new Abalone();

        ////// DM
        DameChinoise dm = new DameChinoise(2, 1, "PRISE");
        dm.addJoueur("Quentin");
        dm.addJoueur("Stephane");
        //dm.addJoueur("Louison");
        dm.setTourJoueur(dm.getJoueur().get(0)); //set le tour en cours sur le premier joueur renseigné


        /////// AJOUT JEUX SUR FENETRE
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

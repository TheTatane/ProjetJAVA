package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class Abalone extends Jeux {

    /*
    CONSTRUCTEUR
     */
    public Abalone() {
        this.modeJeu="";
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.joueur=new ArrayList<String>();
        this.plateau=new PlateauAbalone(/*this.jcolor*/);
    }

    @Override
    public void tourSuivant() {

    }

    @Override
    public int checkVictoire() {
        return 0;
    }

    @Override
    public String getVictoriousName() {
        return null;
    }

    @Override
    public String getJoueurFromColor(Color color) {
        return null;
    }


    //Début de test pour les déplacements
    public void jouerCoup(char direction, int pion)
    {

        int val;

        switch (direction)
        {
            case 'H' : System.out.println("ici");
                if(plateau.getPlateau()[pion].getH_gauche()==null);
            {
                val=plateau.getPlateau()[pion].getPion().getValeur();
                plateau.getPlateau()[pion].getPion().setValeur(0);
                plateau.getPlateau()[pion].getH_gauche().getPion().setValeur(val);
            }

            break;
            case 'B' : break;
            case 'D' : break;

        }
    }




    /*
    GETTER & SETTER
     */


}

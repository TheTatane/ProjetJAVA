package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class DameChinoise extends Jeux {

    private int nbColorByPlayer;
    /*
    CONSTRUCTEUR
     */
    public DameChinoise(int nbJoueur, int nbColor, String mode){
        this.modeJeu=mode;
        this.score=new int[nbJoueur];
        this.joueur=new ArrayList<String>();
        this.jcolor = new ArrayList[nbJoueur];
        this.nbColorByPlayer=nbColor;
        for(int i=0; i<nbJoueur; i++){
            this.jcolor[i]=new ArrayList<Color>();
        }
        this.plateau=new PlateauDC(this.jcolor, nbColorByPlayer, nbJoueur, this.modeJeu);
    }

    public DameChinoise(){
        this.modeJeu="";
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.joueur=new ArrayList<String>();
        this.plateau=new PlateauDC(this.jcolor, 1, 2, this.modeJeu);
    }

    public void tourSuivant(){
        int indexOfSuivant = (this.joueur.indexOf(this.tourJoueur))+1;
        if(indexOfSuivant==this.joueur.size())
            indexOfSuivant=0;
        this.tourJoueur = this.joueur.get(indexOfSuivant);
    }
}

package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class DameChinoise extends Jeux {

    /*
    CONSTRUCTEUR
     */
    public DameChinoise(int nbJoueur){
        this.modeJeu="";
        this.joueur=new String[nbJoueur];
        this.score=new int[nbJoueur];
        this.jcolor = new ArrayList[nbJoueur];
        for(int i=0; i<nbJoueur; i++){
            this.jcolor[i]=new ArrayList<Color>();
        }
        this.plateau=new PlateauDC(this.jcolor);
    }

    public DameChinoise(){
        this.modeJeu="";
        this.joueur=new String[2];
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.plateau=new PlateauDC(this.jcolor);
    }
}

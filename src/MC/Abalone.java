package MC;

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
        this.joueur=new String[2];
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.plateau=new PlateauAbalone(this.jcolor);
    }

    /*
    GETTER & SETTER
     */


}

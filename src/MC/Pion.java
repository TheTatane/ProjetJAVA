package MC;

import java.awt.*;

public class Pion {
    private Color couleur;

    public Pion(){couleur=null;}
    public Pion(Color C){
        couleur=C;
    }

    public Color getCouleur() {
        if(this.couleur==null){
            return Color.white;
        }
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Pion{" +
                "couleur=" + couleur +
                '}';
    }
}

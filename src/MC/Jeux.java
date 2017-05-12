package MC;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class Jeux {
    protected Plateau plateau;
    protected String joueur[];
    protected int score[];
    protected String modeJeu;

    /*
    CONSTRUCTEUR
     */

    public Jeux() {}

    /*
        GETTER & SETTER
    */
    public String[] getJoueur() {
        return joueur;
    }

    public void setJoueur(String[] joueur) {
        this.joueur = joueur;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String getModeJeu() {
        return modeJeu;
    }

    public void setModeJeu(String modeJeu) {
        this.modeJeu = modeJeu;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}

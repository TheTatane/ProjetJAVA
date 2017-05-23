package MC;


public abstract class Plateau {

    protected Case plateau[];

    public Plateau() { }

    public abstract void affiche_plateau();

    public Case[] getPlateau() {
        return plateau;
    }

    public Case getCase(int i){
        return plateau[i];
    }

}
package MC;


public abstract class Plateau {
    protected Case plateau[];

    public Plateau(){}

    public void parcours_graphe_console() {

        for (int i = 1; i <= plateau.length-1; i++) {
            System.out.println("le noeud "+i+" a pour voisin : " + plateau[i].getId());
            afficher_voisins_console(plateau[i]);
        }
    }

    public void afficher_voisins_console(Case c) {
        if (c.getDroite() != null) {
            System.out.println(" \t droite : " + c.getDroite().getId());
        }
        if (c.getGauche() != null) {
            System.out.println(" \t gauche : " + c.getGauche().getId());
        }
        if (c.getB_droite() != null) {
            System.out.println(" \t bas_d : " + c.getB_droite().getId());
        }
        if (c.getB_gauche() != null) {
            System.out.println(" \t bas_g : " + c.getB_gauche().getId());
        }
        if (c.getH_droite() != null) {
            System.out.println(" \t haut_d : " + c.getH_droite().getId());
        }
        if (c.getH_gauche() != null) {
            System.out.println(" \t haut_g : " + c.getH_gauche().getId());
        }
        System.out.println("\n");
    }

    public abstract void createBoard();

    public Case[] getPlateau() {
        return plateau;
    }

    public Case getCase(int i){
        return plateau[i];
    }

}
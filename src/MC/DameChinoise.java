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
/*
    @Override
    public int checkVictoire() {
        if(victoire_br1(plateau.getCase(1))){
            System.out.println("v1");
            return 1;
        }

        if(victoire_br2(plateau.getCase(11))){
            System.out.println("v2");
            return 2;
        }

        if(victoire_br3(plateau.getCase(99))){
            System.out.println("v3");
            return 3;
        }

        if(victoire_br4(plateau.getCase(121))){
            System.out.println("v4");
            return 4;
        }

        if(victoire_br5(plateau.getCase(111))){
            System.out.println("v5");
            return 5;
        }

        if(victoire_br6(plateau.getCase(23))){
            System.out.println("v6");
            return 6;
        }
        return 0;
    }
*/

    @Override
    public int checkVictoire() {
        if(modeJeu.equals("PRISE")){
            // On compte le nombre de pion rouge & bleu
            int countRed=0, countBlue=0;
            for(int i=1; i<=121; i++){
                if(plateau.getCase(i).getPion().getCouleur()== Color.red)
                    countRed++;
                else if(plateau.getCase(i).getPion().getCouleur()== Color.blue)
                    countBlue++;
            }
            //on verifie si tous les pions d'une couleur on été mangé
            if(countBlue==0) //tous les pions bleu mangé --> victoire j1
                return 0;
            else if(countRed==0) // tous les pions rouge mangé --> victoire j2
                return 1;
            else                // personne n'a encore gagné
                return -1;
        }
        else {
            //Pour chaque joueur
            for (int i = 0; i < joueur.size(); i++) {
                int nbColorWinRequired = jcolor[i].size();
                int nbColorWin = 0;
                // on verifie si chaque couleur est dans la branche opposé
                for (Color color : jcolor[i]) {
                    if (color.equals(Color.red)) {
                        if (victoire_br4(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.blue)) {
                        if (victoire_br1(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.pink)) {
                        if (victoire_br6(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.yellow)) {
                        if (victoire_br3(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.black)) {
                        if (victoire_br2(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.green)) {
                        if (victoire_br5(plateau.getCase(121)))
                            nbColorWin++;
                    }
                }
                if (nbColorWinRequired == nbColorWin)
                    return i; // retourne joueur 1 ou 2 ou ...
            }
            // 0 si aucun joueur a gagne
            return -1;
        }
    }

    //parcours sous graphe de racine 1
    public boolean victoire_br1(Case c){
        if(c.getId() > 10)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.red && c.getEtat() != 0) {
                return victoire_br1(c.getB_gauche()) && victoire_br1(c.getB_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 11
    public boolean victoire_br2(Case c){
        if(c.getId() == 47 || c.getId() == 37 || c.getId() == 26 || c.getId() == 14)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.green && c.getEtat() != 0) {
                return victoire_br2(c.getDroite()) && victoire_br2(c.getB_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 99
    public boolean victoire_br3(Case c){
        if(c.getId() == 66 || c.getId() == 77 || c.getId() == 89 || c.getId() == 102)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.pink && c.getEtat() != 0) {
                return victoire_br3(c.getDroite()) && victoire_br3(c.getH_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 121
    public boolean victoire_br4(Case c){
        if(c.getId() < 112)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.blue && c.getEtat() != 0) {
                return victoire_br4(c.getH_droite()) && victoire_br4(c.getH_gauche());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 111
    public boolean victoire_br5(Case c){
        if(c.getId() == 108 || c.getId() == 96 || c.getId() == 85 || c.getId() == 75)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.black && c.getEtat() != 0) {
                return victoire_br5(c.getGauche()) && victoire_br5(c.getH_gauche());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 23
    public boolean victoire_br6(Case c){
        if(c.getId() == 20 || c.getId() == 33 || c.getId() == 45 || c.getId() == 56)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.yellow && c.getEtat() != 0) {
                return victoire_br6(c.getB_gauche()) && victoire_br6(c.getGauche());
            }
            else{
                return false;
            }
        }
    }

    @Override
    public String getVictoriousName() {
        return joueur.get(checkVictoire());
    }

    @Override
    public String getJoueurFromColor(Color color) {
        for(int i=0; i<jcolor.length; i++){
            for(Color c : jcolor[i]){
                if(color.equals(c))
                    return joueur.get(i);
            }
        }
        return null;
    }


}

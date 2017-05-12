package MC;

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
        plateau=new Plateau("DAME CHINOISE");
        plateau.create_board_chinois();
    }

    public DameChinoise(){
        this.modeJeu="";
        this.joueur=new String[2];
        this.score=new int[2];
        plateau=new Plateau("DAME CHINOISE");
        plateau.create_board_chinois();
    }

    public void youpi(){
        System.out.println("youpi");
    }

    /*
    GETTER & SETTER
     */
}

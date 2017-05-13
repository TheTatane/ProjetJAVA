import MC.Abalone;
import MC.DameChinoise;
import MC.Jeux;
import MC.Plateau;
import View.Fenetre;

public class Main {
    public static void main (String[] args){

        Fenetre f = new Fenetre(1100, 800, "Jeux");
        DameChinoise dm = new DameChinoise(2);
        f.dameChinoiseUI.draw(dm.getPlateau());
    }
}

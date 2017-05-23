package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 19/05/2017.
 */
public class PlateauAbalone extends Plateau{

    public PlateauAbalone(ArrayList<Color> joueurColor[]) {
        plateau = new Case[62];
        for (int i = 0; i <= 61; i++) {
            plateau[i] = new Case(i, 0, null, null, null, null, null, null);
        }
        createBoard();
    }

    public void createBoard() {
        int i;
        //row 1
        for(i=1; i<=5; i++){
            if(i != 1)
                plateau[i].setGauche(plateau[i-1]);
            if(i != 5)
                plateau[i].setDroite(plateau[i+1]);
            plateau[i].setB_gauche(plateau[i+5]);
            plateau[i].setB_droite(plateau[i+6]);
        }

        //row 2
        for(i=6; i<=11; i++){
            if(i != 6) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-6]);
            }
            if(i != 11) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-5]);
            }
            plateau[i].setB_gauche(plateau[i+6]);
            plateau[i].setB_droite(plateau[i+7]);
        }
        //row 3
        for(i=12; i<=18; i++){
            if(i != 12) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-7]);
            }
            if(i != 18) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-6]);
            }
            plateau[i].setB_gauche(plateau[i+7]);
            plateau[i].setB_droite(plateau[i+8]);
        }
        //row 4
        for(i=19; i<=26; i++){
            if(i != 19) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-8]);
            }
            if(i != 26) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-7]);
            }
            plateau[i].setB_gauche(plateau[i+8]);
            plateau[i].setB_droite(plateau[i+9]);
        }
        //row 5 (MILIEU)
        for(i=27; i<=35; i++){
            if(i != 27) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-6]);
                plateau[i].setB_gauche(plateau[i+5]);
            }
            if(i != 35) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-5]);
                plateau[i].setB_droite(plateau[i+6]);
            }
        }
        //row 6
        for(i=36; i<=43; i++){
            if(i != 36) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+7]);
            }
            if(i != 43) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+8]);
            }
            plateau[i].setH_gauche(plateau[i-9]);
            plateau[i].setH_droite(plateau[i-8]);
        }
        //row 7
        for(i=44; i<=50; i++){
            if(i != 44) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+6]);
            }
            if(i != 50) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+7]);
            }
            plateau[i].setH_gauche(plateau[i-8]);
            plateau[i].setH_droite(plateau[i-7]);
        }
        //row 8
        for(i=51; i<=56; i++){
            if(i != 51) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+5]);
            }
            if(i != 56) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+6]);
            }
            plateau[i].setH_gauche(plateau[i-7]);
            plateau[i].setH_droite(plateau[i-6]);
        }
        //row 9
        for(i=57; i<=61; i++){
            if(i != 57)
                plateau[i].setGauche(plateau[i - 1]);
            if(i != 61)
                plateau[i].setDroite(plateau[i + 1]);

            plateau[i].setH_gauche(plateau[i-6]);
            plateau[i].setH_droite(plateau[i-5]);
        }
    }
}

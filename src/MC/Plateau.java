package MC;


public class Plateau {
    private Case plateau[];

    public Plateau(String jeu) {
        switch (jeu) {
            case "ABALONE":
                plateau = new Case[62];
                for (int i = 0; i <= 61; i++) {
                    plateau[i] = new Case(i, 0, null, null, null, null, null, null);
                }
                break;
            case "DAME CHINOISE":
                plateau = new Case[122];
                for (int i = 0; i <= 121; i++) {
                    plateau[i] = new Case(i, 0, null, null, null, null, null, null);
                }
                break;
        }
    }

    public void create_board_chinois() {
        /////////////////////////////////  TRIANGLE SOMMET ///////////////////////////////////
        //N1

        plateau[1].setB_gauche(plateau[2]);
        plateau[1].setB_droite(plateau[3]);
        //N2
        plateau[2].setDroite(plateau[3]);
        plateau[2].setB_gauche(plateau[4]);
        plateau[2].setB_droite(plateau[5]);
        plateau[2].setH_droite(plateau[1]);
        plateau[3].setGauche(plateau[2]);
        plateau[3].setB_gauche(plateau[5]);
        plateau[3].setB_droite(plateau[6]);
        plateau[3].setH_gauche(plateau[1]);
        //N3
        plateau[4].setDroite(plateau[5]);
        plateau[4].setB_gauche(plateau[7]);
        plateau[4].setB_droite(plateau[8]);
        plateau[4].setH_droite(plateau[2]);
        plateau[5].setGauche(plateau[4]);
        plateau[5].setDroite(plateau[6]);
        plateau[5].setH_gauche(plateau[2]);
        plateau[5].setH_droite(plateau[3]);
        plateau[5].setB_gauche(plateau[8]);
        plateau[5].setB_droite(plateau[9]);
        plateau[6].setH_gauche(plateau[3]);
        plateau[6].setGauche(plateau[5]);
        plateau[6].setB_gauche(plateau[9]);
        plateau[6].setB_droite(plateau[10]);


        ////////////////////////////////  CORPS ETOILE ///////////////////////////////////////
        //ETAGE 0
        int i = 0;
        for (i = 7; i < 7 + 4; i++) {
            plateau[i].setB_droite(plateau[i + 9]);
            plateau[i].setB_gauche(plateau[i + 8]);
            if (i != 10) {
                plateau[i].setH_droite(plateau[i - 3]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 7) {
                plateau[i].setH_gauche(plateau[i - 4]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }


        // ETAGE 1
        for (i = 11; i < 11 + 13; i++) {
            if (!est_bordure_d(i, 1)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 13]);
            }
            if (!est_bordure_g(i, 1)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 12]);
            }
        }

        plateau[15].setH_droite(plateau[7]);
        plateau[16].setH_gauche(plateau[7]);
        plateau[16].setH_droite(plateau[8]);
        plateau[17].setH_gauche(plateau[8]);
        plateau[17].setH_droite(plateau[9]);
        plateau[18].setH_gauche(plateau[9]);
        plateau[18].setH_droite(plateau[10]);
        plateau[19].setH_gauche(plateau[10]);

        // ETAGE 2
        for (i = 24; i < 24 + 12; i++) {
            if (!est_bordure_d(i, 2)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 12]);
            }
            if (!est_bordure_g(i, 2)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 11]);
            }
            plateau[i].setH_gauche(plateau[i - 13]);
            plateau[i].setH_droite(plateau[i - 12]);
        }

        // ETAGE 3
        for (i = 36; i < 36 + 11; i++) {
            if (!est_bordure_d(i, 3)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 11]);
            }

            if (!est_bordure_g(i, 3)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 10]);
            }
            plateau[i].setH_droite(plateau[i - 11]);
            plateau[i].setH_gauche(plateau[i - 12]);
        }

        // ETAGE 4
        for (i = 47; i < 47 + 10; i++) {
            if (!est_bordure_d(i, 4)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 10]);
            }

            if (!est_bordure_g(i, 4)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 9]);
            }
            plateau[i].setH_droite(plateau[i - 10]);
            plateau[i].setH_gauche(plateau[i - 11]);
        }

        // ETAGE 5
        for (i = 57; i < 57 + 9; i++) {
            if (!est_bordure_d(i, 5)) {
                plateau[i].setDroite(plateau[i + 1]);
            }

            if (!est_bordure_g(i, 5)) {
                plateau[i].setGauche(plateau[i - 1]);
            }
            plateau[i].setH_droite(plateau[i - 9]);
            plateau[i].setH_gauche(plateau[i - 10]);
            plateau[i].setB_droite(plateau[i + 10]);
            plateau[i].setB_gauche(plateau[i + 9]);
        }

        /////////////////////////////// MILIEU CORPS /////////////////////////////////
        // ETAGE 6
        for (i = 66; i < 66 + 10; i++) {
            if (!est_bordure_d(i, 6)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 9]);
            }

            if (!est_bordure_g(i, 6)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 10]);
            }
            plateau[i].setB_droite(plateau[i + 11]);
            plateau[i].setB_gauche(plateau[i + 10]);
        }

        // ETAGE 7
        for (i = 76; i < 76 + 11; i++) {
            if (!est_bordure_d(i, 7)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 10]);
            }

            if (!est_bordure_g(i, 7)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 11]);
            }
            plateau[i].setB_droite(plateau[i + 12]);
            plateau[i].setB_gauche(plateau[i + 11]);
        }

        // ETAGE 8
        for (i = 87; i < 87 + 12; i++) {
            if (!est_bordure_d(i, 8)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 11]);
            }
            if (!est_bordure_g(i, 8)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 12]);
            }
            plateau[i].setB_droite(plateau[i + 13]);
            plateau[i].setB_gauche(plateau[i + 12]);
        }

        // ETAGE 9
        for (i = 99; i < 99 + 13; i++) {
            if (!est_bordure_d(i, 9)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 12]);
            }

            if (!est_bordure_g(i, 9)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 13]);
            }

        }

        plateau[103].setB_droite(plateau[112]);
        plateau[104].setB_gauche(plateau[112]);
        plateau[104].setB_droite(plateau[113]);
        plateau[105].setB_gauche(plateau[113]);
        plateau[105].setB_droite(plateau[114]);
        plateau[106].setB_gauche(plateau[114]);
        plateau[106].setB_droite(plateau[115]);
        plateau[107].setB_gauche(plateau[115]);

        /////////////////////////////////  TRIANGLE BASE ///////////////////////////////////
        //ETAGE 10
        for (i = 112; i < 112 + 4; i++) {
            plateau[i].setH_droite(plateau[i - 8]);
            plateau[i].setH_gauche(plateau[i - 9]);
            if (i != 115) {
                plateau[i].setB_droite(plateau[i + 4]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 112) {
                plateau[i].setB_gauche(plateau[i + 3]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }

        for (i = 116; i < 116 + 3; i++) {
            plateau[i].setH_droite(plateau[i - 3]);
            plateau[i].setH_gauche(plateau[i - 4]);
            if (i != 118) {
                plateau[i].setB_droite(plateau[i + 3]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 116) {
                plateau[i].setB_gauche(plateau[i + 2]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }

        for (i = 119; i < 119 + 2; i++) {
            plateau[i].setH_droite(plateau[i - 2]);
            plateau[i].setH_gauche(plateau[i - 3]);
            if (i == 119) {
                plateau[i].setB_droite(plateau[i + 2]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i == 120) {
                plateau[i].setB_gauche(plateau[i + 1]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }
        plateau[121].setH_droite(plateau[120]);
        plateau[121].setH_gauche(plateau[119]);
    }

    public void create_board_abalone() {
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

    public boolean est_bordure_d(int pos, int etage) {
        switch (etage) {
            case 0:
                if (pos == 10) return true;
                break;
            case 1:

                if (pos == 23) return true;
                break;
            case 2:

                if (pos == 35) return true;
                break;
            case 3:
                if (pos == 46) return true;
                break;
            case 4:
                if (pos == 56) return true;
                break;
            case 5:
                if (pos == 65) return true;
                break;
            case 6:
                if (pos == 75) return true;
                break;
            case 7:
                if (pos == 86) return true;
                break;
            case 8:
                if (pos == 98) return true;
                break;
            case 9:
                if (pos == 111) return true;
                break;
            case 10:
                if (pos == 115) return true;
                break;
        }

        return false;
    }

    public boolean est_bordure_g(int pos, int etage) {
        switch (etage) {
            case 0:
                if (pos == 7) return true;
                break;
            case 1:

                if (pos == 11) return true;
                break;
            case 2:

                if (pos == 24) return true;
                break;
            case 3:
                if (pos == 36) return true;
                break;
            case 4:
                if (pos == 47) return true;
                break;
            case 5:
                if (pos == 57) return true;
                break;
            case 6:
                if (pos == 66) return true;
                break;
            case 7:
                if (pos == 77) return true;
                break;
            case 8:
                if (pos == 87) return true;
                break;
            case 9:
                if (pos == 99) return true;
                break;
            case 10:
                if (pos == 112) return true;
                break;
        }

        return false;
    }

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

    public Case[] getPlateau() {
        //
        return plateau;
    }

}
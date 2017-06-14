package MC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class Abalone extends Jeux {

    /*
    CONSTRUCTEUR
     */
    public Abalone() {
        this.modeJeu="";
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.joueur=new ArrayList<String>();
        this.plateau=new PlateauAbalone(/*this.jcolor*/);
    }

    @Override
    public void tourSuivant() {

    }


    //Début de test pour les déplacements
    public void jouerCoup(int direction, ArrayList<Integer> listPion)
    {

        Collections.sort(listPion);

        int cpt;
        int adversaire=0;
        int score;
        adversaire= plateau.getPlateau()[listPion.get(0)].getPion().getValeur() == 1 ? 2 : 1;

        switch (direction)
        {
            case 1 :
                System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getH_gauche()==null || plateau.getPlateau()[listPion.get(0)].getH_gauche().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getH_gauche() !=null && plateau.getPlateau()[listPion.get(0)].getH_gauche().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireHautGauche(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche()!=null && plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getH_gauche().getId();
                                plateau.getPlateau()[id].getH_gauche().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getH_gauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getH_gauche().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche()!=null && plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getH_gauche().getId();
                                plateau.getPlateau()[id2].getH_gauche().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getH_gauche().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getH_gauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getH_gauche().setEtat(0);
                            }
                        }
                        decalageHautGauche(listPion);
                    }
                    else
                    {
                        //poussé impossible
                    }
                }

            break;
            case 2 :
               System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getH_droite()==null || plateau.getPlateau()[listPion.get(0)].getH_droite().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getH_droite() !=null && plateau.getPlateau()[listPion.get(0)].getH_droite().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireHautDroit(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite()!=null && plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getH_droite().getId();
                                plateau.getPlateau()[id].getH_droite().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getH_droite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getH_droite().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite().getH_droite()!=null && plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite().getH_droite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getH_droite().getId();
                                plateau.getPlateau()[id2].getH_droite().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getH_droite().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getH_droite().getH_droite().getH_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getH_droite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getH_droite().setEtat(0);
                            }
                        }
                        decalageHautDroit(listPion);
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
            case 3 :
                System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getDroite()==null || plateau.getPlateau()[listPion.get(0)].getDroite().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getDroite() !=null && plateau.getPlateau()[listPion.get(0)].getDroite().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireDroit(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getDroite().getDroite()!=null && plateau.getPlateau()[listPion.get(0)].getDroite().getDroite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getDroite().getId();
                                plateau.getPlateau()[id].getDroite().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getDroite().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getDroite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getDroite().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getDroite().getDroite().getDroite()!=null && plateau.getPlateau()[listPion.get(0)].getDroite().getDroite().getDroite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getDroite().getDroite().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getDroite().getId();
                                plateau.getPlateau()[id2].getDroite().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getDroite().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getDroite().getDroite().getDroite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getDroite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getDroite().setEtat(0);
                            }
                        }
                        decalageDroit(listPion);
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 4 :
                System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getB_droite()==null || plateau.getPlateau()[listPion.get(0)].getB_droite().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getB_droite() !=null && plateau.getPlateau()[listPion.get(0)].getB_droite().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireBasDroit(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getB_droite().getDroite()!=null && plateau.getPlateau()[listPion.get(0)].getB_droite().getB_droite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getB_droite().getId();
                                plateau.getPlateau()[id].getB_droite().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getB_droite().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getB_droite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getB_droite().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getB_droite().getB_droite().getB_droite()!=null && plateau.getPlateau()[listPion.get(0)].getB_droite().getB_droite().getB_droite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getB_droite().getDroite().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getB_droite().getId();
                                plateau.getPlateau()[id2].getB_droite().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getB_droite().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getB_droite().getB_droite().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getB_droite().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getB_droite().setEtat(0);
                            }
                        }
                        decalageBasDroit(listPion);
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 5 :
                 System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getB_gauche()==null || plateau.getPlateau()[listPion.get(0)].getB_gauche().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getB_gauche() !=null && plateau.getPlateau()[listPion.get(0)].getB_gauche().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireBasGauche(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getB_gauche().getB_gauche()!=null && plateau.getPlateau()[listPion.get(0)].getB_gauche().getB_gauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getB_gauche().getId();
                                plateau.getPlateau()[id].getB_gauche().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getB_gauche().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getB_gauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getB_gauche().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getB_gauche().getB_gauche().getB_gauche()!=null && plateau.getPlateau()[listPion.get(0)].getB_gauche().getB_gauche().getB_gauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getB_gauche().getDroite().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getB_gauche().getId();
                                plateau.getPlateau()[id2].getB_gauche().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getB_gauche().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getB_gauche().getB_gauche().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getB_gauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getB_gauche().setEtat(0);
                            }
                        }
                        decalageBasGauche(listPion);
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 6 :
                 System.out.println("debug adv : "+adversaire);

                if(plateau.getPlateau()[listPion.get(0)].getGauche()==null || plateau.getPlateau()[listPion.get(0)].getGauche().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                }
                else if(plateau.getPlateau()[listPion.get(0)].getGauche() !=null && plateau.getPlateau()[listPion.get(0)].getGauche().getPion().getValeur() == adversaire)
                {
                    cpt=comptagePionAdversaireGauche(listPion.get(0),adversaire);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau.getPlateau()[listPion.get(0)].getGauche().getGauche()!=null && plateau.getPlateau()[listPion.get(0)].getGauche().getGauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau.getPlateau()[listPion.get(0)].getGauche().getId();
                                plateau.getPlateau()[id].getGauche().getPion().setValeur(corpDeplacement(corpDeplacement(id)));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getGauche().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getGauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getGauche().setEtat(0);
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau.getPlateau()[listPion.get(0)].getGauche().getGauche().getGauche()!=null && plateau.getPlateau()[listPion.get(0)].getGauche().getGauche().getGauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau.getPlateau()[listPion.get(0)].getGauche().getGauche().getId();
                                id2=plateau.getPlateau()[listPion.get(0)].getGauche().getId();
                                plateau.getPlateau()[id2].getGauche().getPion().setValeur(corpDeplacement(id));
                                plateau.getPlateau()[id].getGauche().getPion().setValeur(corpDeplacement(id2));
                            }
                            else if ( plateau.getPlateau()[listPion.get(0)].getGauche().getGauche().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau.getPlateau()[listPion.get(0)].getGauche().getPion().setValeur(0);
                                plateau.getPlateau()[listPion.get(0)].getGauche().setEtat(0);
                            }
                        }
                        decalageGauche(listPion);
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;
        }
    }

    public int corpDeplacement (int pion)
    {
        int val;
        val=plateau.getPlateau()[pion].getPion().getValeur();
        plateau.getPlateau()[pion].getPion().setValeur(0);
        plateau.getPlateau()[pion].setEtat(0);
        plateau.getPlateau()[pion].getH_gauche().setEtat(1);

        return val;
    }

    public int comptagePionAdversaireHautGauche(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getH_gauche().getH_gauche() !=null && plateau.getPlateau()[pion].getH_gauche().getH_gauche().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getH_gauche().getH_gauche().getH_gauche() !=null && plateau.getPlateau()[pion].getH_gauche().getH_gauche().getH_gauche().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getH_gauche().getH_gauche().getH_gauche().getH_gauche() !=null && plateau.getPlateau()[pion].getH_gauche().getH_gauche().getH_gauche().getH_gauche().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireHautDroit(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getH_droite().getH_droite() !=null && plateau.getPlateau()[pion].getH_gauche().getH_droite().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getH_droite().getH_droite().getH_droite() !=null && plateau.getPlateau()[pion].getH_droite().getH_droite().getH_droite().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getH_droite().getH_droite().getH_droite().getH_droite() !=null && plateau.getPlateau()[pion].getH_droite().getH_droite().getH_droite().getH_droite().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireDroit(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getDroite().getDroite() !=null && plateau.getPlateau()[pion].getDroite().getDroite().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getDroite().getDroite().getDroite() !=null && plateau.getPlateau()[pion].getDroite().getDroite().getDroite().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getDroite().getDroite().getDroite().getDroite() !=null && plateau.getPlateau()[pion].getDroite().getDroite().getDroite().getDroite().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireBasDroit(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getB_droite().getB_droite() !=null && plateau.getPlateau()[pion].getB_droite().getB_droite().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getB_droite().getB_droite().getB_droite() !=null && plateau.getPlateau()[pion].getB_droite().getB_droite().getB_droite().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getB_droite().getB_droite().getB_droite().getB_droite() !=null && plateau.getPlateau()[pion].getB_droite().getB_droite().getB_droite().getB_droite().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireBasGauche(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getB_gauche().getB_gauche() !=null && plateau.getPlateau()[pion].getB_gauche().getB_gauche().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getB_gauche().getB_gauche().getB_gauche() !=null && plateau.getPlateau()[pion].getB_gauche().getB_gauche().getB_gauche().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getB_gauche().getB_gauche().getB_gauche().getB_gauche() !=null && plateau.getPlateau()[pion].getB_gauche().getB_gauche().getB_gauche().getB_gauche().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireGauche(int pion, int adversaire)
    {
        int cpt=1;

        if(plateau.getPlateau()[pion].getGauche().getGauche() !=null && plateau.getPlateau()[pion].getGauche().getGauche().getPion().getValeur()==adversaire)
        {
            cpt++;
            if(plateau.getPlateau()[pion].getGauche().getGauche().getGauche() !=null && plateau.getPlateau()[pion].getGauche().getGauche().getGauche().getPion().getValeur()==adversaire)
            {
                cpt++;
                if(plateau.getPlateau()[pion].getGauche().getGauche().getGauche().getGauche() !=null && plateau.getPlateau()[pion].getGauche().getGauche().getGauche().getGauche().getPion().getValeur()==adversaire)
                {
                    cpt++;
                }
            }
        }

        return cpt;
    }


    public void decalageHautGauche(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getH_gauche() == null || plateau.getPlateau()[pion].getH_gauche().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getH_gauche().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }

    public void decalageHautDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getH_droite() == null || plateau.getPlateau()[pion].getH_droite().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getH_droite().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }

    public void decalageDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getDroite() == null || plateau.getPlateau()[pion].getDroite().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getDroite().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }

    public void decalageBasDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getDroite() == null || plateau.getPlateau()[pion].getDroite().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getDroite().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }

    public void decalageBasGauche(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getB_gauche() == null || plateau.getPlateau()[pion].getB_gauche().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getB_gauche().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }

    public void decalageGauche(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau.getPlateau()[pion].getGauche() == null || plateau.getPlateau()[pion].getGauche().getEtat() == 0)
            {
                plateau.getPlateau()[pion].getGauche().getPion().setValeur(corpDeplacement(pion));
            }
        }
    }



    /*
    GETTER & SETTER
     */


}

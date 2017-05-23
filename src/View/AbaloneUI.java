package View;

import MC.Case;
import MC.Jeux;
import MC.Plateau;
import MC.PlateauAbalone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class AbaloneUI extends JPanel implements ActionListener {


    JButton tabbutton[] = new JButton[63];
    Plateau plateau;
    Jeux game;


    public AbaloneUI(Jeux jeu) {

        game = jeu;
        this.setBackground(new Color(255, 208, 186, 137));
        this.setLayout(new GridBagLayout());

        plateau = game.getPlateau();


        for (int i = 1; i <= 62; i++) {
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(20, 20));
            //tabbutton[i].setBackground(plateau.getPlateau()[i].getPion().getCouleur());
            tabbutton[i].setName(Integer.toString(i));
        }

        affichePlateau();
    }

        public void affichePlateau()
        {
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.gridx=5;constraint.gridy=4;
            constraint.gridheight=1; constraint.gridwidth=1;
            constraint.ipadx=2; constraint.ipady=2;

            int taille=4, ligne=0;
            for(int i=1; i< 62 ; i++)
            {

                tabbutton[i].setText(Integer.toString(i));

                if(plateau.getPlateau()[i].getDroite() == null)
                {
                    tabbutton[i].addActionListener(this);
                    this.add(tabbutton[i], constraint);

                    if (i<34 )
                    {
                        constraint.gridy += 1;
                        constraint.gridx = taille-ligne;
                    }
                    else
                    {
                        constraint.gridy += 1;
                        constraint.gridx = ligne;
                    }
                     ligne = i == 26 ? 2 : ligne+1;

                }
                else
                {
                    tabbutton[i].addActionListener(this);
                    this.add(tabbutton[i], constraint);
                    constraint.gridx += 2;
                }
            }
        }

    /*

    public AbaloneUI(Plateau p){
        this.setBackground(Color.black);
        //draw grid ?
    }

    public void draw(Plateau p){
        System.out.println("Abalone draw");
    }

    */

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}

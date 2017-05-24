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
    JPanel panelGlobal;
    JPanel panelJeu;
    JPanel panelInfoJeu;
    Font policeTitle;
    JLabel labelTitle;
    Jeux game;

    public AbaloneUI(Jeux jeu) {

        game = jeu;
        //this.setBackground(new Color(255, 208, 186, 137));
        //this.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout());

        // Police
        policeTitle = new Font("Arial", Font.BOLD, 20);

        //Label
        labelTitle = new JLabel("TEST");
        labelTitle.setFont(policeTitle);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setPreferredSize(new Dimension(540,30));

        panelGlobal = new JPanel(new BorderLayout());
        panelJeu = new JPanel(new GridBagLayout());
        panelJeu.setBackground(new Color(255, 208, 186, 137));
        panelInfoJeu = new JPanel(new BorderLayout());
        panelInfoJeu.setBackground(new Color(255, 208, 186, 137));

        plateau = game.getPlateau();


        for (int i = 1; i < 62; i++) {
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(20, 20));
            tabbutton[i].setBorder(new RoundedBorder(50));
            tabbutton[i].setBackground(Color.darkGray);
            tabbutton[i].setForeground(plateau.getPlateau()[i].getPion().getCouleur());
            tabbutton[i].setName(Integer.toString(i));
        }

        affichePlateau();
        panelInfoJeu.add(labelTitle);
        panelGlobal.add(panelJeu, BorderLayout.CENTER);
        panelGlobal.add(panelInfoJeu, BorderLayout.EAST);
        this.add(panelGlobal, BorderLayout.CENTER);
    }

        public void affichePlateau()
        {
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.gridx=5;constraint.gridy=4;
            constraint.gridheight=1; constraint.gridwidth=1;
            constraint.ipadx=8; constraint.ipady=8;

            int taille=4, ligne=0;
            for(int i=1; i< 62 ; i++)
            {

                tabbutton[i].setText(Integer.toString(i));

                if(plateau.getPlateau()[i].getDroite() == null)
                {
                    tabbutton[i].addActionListener(this);
                    panelJeu.add(tabbutton[i], constraint);

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
                    panelJeu.add(tabbutton[i], constraint);
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

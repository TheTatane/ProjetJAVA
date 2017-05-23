package View;

import MC.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class DameChinoiseUI extends JPanel implements ActionListener {

    JButton tabbutton[] = new JButton[122];
    PlateauDC plateau;
    Jeux dc;

    int idsrc=0, iddest=0;

    public DameChinoiseUI(Jeux jeu){
        this.setBackground(Color.cyan);
        this.setLayout(new GridBagLayout());
        plateau= (PlateauDC) jeu.getPlateau();
        dc=jeu;
        for(int i=1; i<=121; i++){
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(23,20));
            tabbutton[i].setBackground(Color.cyan);
            tabbutton[i].setName(Integer.toString(i));
            //tabbutton[i].setBorder(new LineBorder(Color.cyan));
            tabbutton[i].setBorder(new RoundedBorder(40));
            tabbutton[i].setForeground(plateau.getPlateau()[i].getPion().getCouleur());

        }
        draw();
    }

    public void draw(){

        int linelength=0;
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx=14;constraint.gridy=0;
        constraint.gridheight=1; constraint.gridwidth=1;
        constraint.ipadx=1; constraint.ipady=5;
        for(int i=1; i<=10; i++){
            int finalI = i;
            tabbutton[i].addActionListener(this);
            this.add(tabbutton[i], constraint);
            linelength++;

            if(plateau.getPlateau()[i].getDroite() == null){
                constraint.gridy += 1;
                constraint.gridx -= (linelength*2)-1;
                linelength=0;
            }
            else{
                constraint.gridx += 2;
            }
        }

        linelength=0;
        constraint.gridx=2; constraint.gridy+=1;
        for(int i=11; i<=111; i++){
            int finalI = i;
            tabbutton[i].addActionListener(this);
            this.add(tabbutton[i], constraint);
            linelength++;
            if(plateau.getPlateau()[i].getDroite() == null && (i>11 && i<65)){
                constraint.gridy += 1;
                constraint.gridx -= ( (linelength*2) -3);
                linelength=0;
            }
            else if(plateau.getPlateau()[i].getDroite() == null && (i>=65 && i<112)){
                constraint.gridy += 1;
                constraint.gridx -= ((linelength*2)-1);
                linelength=0;
            }
            else{
                constraint.gridx += 2;
            }
        }

        constraint.gridx=11;constraint.gridy+=1;
        for(int i=112; i<=121; i++){
            int finalI = i;
            tabbutton[i].addActionListener(this);
            this.add(tabbutton[i], constraint);
            linelength++;

            if(plateau.getPlateau()[i].getDroite() == null){
                constraint.gridy += 1;
                constraint.gridx -= ((linelength*2)-3);
                linelength=0;
            }
            else{
                constraint.gridx += 2;
            }
        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(idsrc==0){
            idsrc = Integer.parseInt(btn.getName());
            int dispo[] = plateau.deplacements_possibles(plateau.getPlateau()[idsrc]);
            for(int i=0; i<6; i++){
                System.out.print(dispo[i]+"/");
            }
            showMouvDispo(dispo);

        }
        else{
            hideMouvDispo(plateau.deplacements_possibles(plateau.getPlateau()[idsrc]));
            iddest = Integer.parseInt(btn.getName());
            if(plateau.deplacementDisponible(idsrc, iddest)){
                if(plateau.isSaut(plateau.getCase(idsrc), plateau.getCase(iddest))) {
                    System.out.println("SAUT");
                    plateau.changePosition(plateau.getCase(idsrc), plateau.getCase(iddest));
                    swapUI(idsrc, iddest);

                }
                else{
                    System.out.println("NORMAL");
                    plateau.changePosition(plateau.getPlateau()[idsrc], plateau.getPlateau()[iddest]);
                    swapUI(idsrc, iddest);
                    setVisible(true);
                }
            }
            else
                System.out.println("Destination non valide");
            idsrc=0;iddest=0;
        }
    }

    public void swapUI(int idsrc, int iddest){
        JButton tmp = tabbutton[iddest];

        tabbutton[iddest].setForeground(tabbutton[idsrc].getForeground());
        tabbutton[idsrc].setForeground(plateau.getCase(idsrc).getPion().getCouleur());

    }

    public void showMouvDispo(int dispo[]){
        for(int i=0; i<6; i++){
            if(dispo[i] != 0){
                tabbutton[dispo[i]].setBorder(new LineBorder(Color.green, 2));
                tabbutton[dispo[i]].setBackground(plateau.getCase(dispo[i]).getPion().getCouleur());
            }
        }
    }

    public void hideMouvDispo(int dispo[]){
        for(int i=0; i<6; i++){
            if(dispo[i] != 0){
                tabbutton[dispo[i]].setBorder(new RoundedBorder(20));
                tabbutton[dispo[i]].setBackground(Color.cyan);
            }
        }
    }
}

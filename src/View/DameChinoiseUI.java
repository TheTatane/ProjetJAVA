package View;

import MC.Case;
import MC.DameChinoise;
import MC.Jeux;
import MC.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class DameChinoiseUI extends JPanel implements ActionListener {

    JButton tabbutton[] = new JButton[122];
    Plateau plateau;
    Jeux dc;

    public DameChinoiseUI(Jeux jeu){
        this.setBackground(Color.cyan);
        this.setLayout(new GridBagLayout());
        plateau=jeu.getPlateau();
        dc=jeu;
        for(int i=1; i<=121; i++){
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(20,20));
            tabbutton[i].setBackground(plateau.getPlateau()[i].getPion().getCouleur());
            tabbutton[i].setName(Integer.toString(i));
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
        int id = Integer.parseInt(btn.getName());
        btn = tabbutton[id];
        Case c = plateau.getCase(id);
        System.out.println(c.toString());
    }
}

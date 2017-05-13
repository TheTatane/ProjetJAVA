package View;

import MC.DameChinoise;
import MC.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class DameChinoiseUI extends JPanel {

    JButton tabbutton[] = new JButton[122];

    public DameChinoiseUI(){
        this.setBackground(Color.cyan);
        this.setLayout(new GridBagLayout());
        for(int i=1; i<=121; i++){
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(20,20));
        }
    }

    public void draw(Plateau p){

        int linelength=0;
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx=14;constraint.gridy=0;
        constraint.gridheight=1; constraint.gridwidth=1;
        constraint.ipadx=1; constraint.ipady=5;
        for(int i=1; i<=10; i++){

            tabbutton[i].setBackground(Color.gray);
            this.add(tabbutton[i], constraint);
            linelength++;

            if(p.getPlateau()[i].getDroite() == null){
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
            tabbutton[i].setBackground(Color.gray);
            this.add(tabbutton[i], constraint);
            linelength++;
            if(p.getPlateau()[i].getDroite() == null && (i>11 && i<65)){
                constraint.gridy += 1;
                constraint.gridx -= ( (linelength*2) -3);
                linelength=0;
            }
            else if(p.getPlateau()[i].getDroite() == null && (i>=65 && i<112)){
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
            tabbutton[i].setBackground(Color.gray);
            this.add(tabbutton[i], constraint);
            linelength++;

            if(p.getPlateau()[i].getDroite() == null){
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
}

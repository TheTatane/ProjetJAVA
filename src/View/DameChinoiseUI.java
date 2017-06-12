package View;

import MC.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class DameChinoiseUI extends JPanel implements ActionListener {

    JPanel panGame=new JPanel(), panTitle=new JPanel(), panOption=new JPanel();
    JButton tabbutton[] = new JButton[122];
    PlateauDC plateau;
    Jeux dc;

    int idsrc=0, iddest=0;

    public DameChinoiseUI(Jeux jeu){
        plateau= (PlateauDC) jeu.getPlateau();
        dc=jeu;

        this.setBackground(Color.darkGray);
        this.setLayout(new BorderLayout());

        panGame.setLayout(new GridBagLayout());
        panGame.setBackground(Color.darkGray);

        panTitle.add(setTitleName());
        for(int i=1; i<=121; i++){
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(23,20));
            tabbutton[i].setBackground(Color.darkGray);
            tabbutton[i].setName(Integer.toString(i));
            tabbutton[i].setBorder(new RoundedBorder(50));
            tabbutton[i].setForeground(plateau.getPlateau()[i].getPion().getCouleur());
        }
        draw();
        this.add(panGame, BorderLayout.CENTER);
        this.add(panTitle, BorderLayout.NORTH);
        this.add(panOption, BorderLayout.SOUTH);
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
            panGame.add(tabbutton[i], constraint);
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
            panGame.add(tabbutton[i], constraint);
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
            panGame.add(tabbutton[i], constraint);
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
            if(dc.pionAppartientJoueurCourant(plateau.getPlateau()[idsrc].getPion().getCouleur())) {
                int dispo[] = plateau.deplacements_possibles(plateau.getPlateau()[idsrc]);
                for (int i = 0; i < 6; i++) {
                    System.out.print(dispo[i] + "/");
                }
                showMouvDispo(dispo);
            }
            else{idsrc=0;}
        }
        else{
            hideMouvDispo(plateau.deplacements_possibles(plateau.getPlateau()[idsrc]));
            iddest = Integer.parseInt(btn.getName());
            if(plateau.deplacementDisponible(idsrc, iddest)){
                if(plateau.isSaut(plateau.getCase(idsrc), plateau.getCase(iddest))) {
                    System.out.println("SAUT");
                    if(!plateau.changePosition(plateau.getCase(idsrc), plateau.getCase(iddest)))
                        dc.tourSuivant();
                    swapUI(idsrc, iddest);
                    refreshNeighbors(idsrc);

                }
                else{
                    System.out.println("NORMAL");
                    plateau.changePosition(plateau.getPlateau()[idsrc], plateau.getPlateau()[iddest]);
                    swapUI(idsrc, iddest);
                    dc.tourSuivant();
                    setVisible(true);
                }
            }
            else
                System.out.println("Destination non valide");
            idsrc=0;iddest=0;
            System.out.println("TOUR COURANT : "+dc.getTourJoueur());
        }
    }

    public void swapUI(int idsrc, int iddest){
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
                tabbutton[dispo[i]].setBackground(Color.darkGray);
            }
        }
    }

    public void refreshNeighbors(int idsrc){
        Case src = plateau.getCase(idsrc);
        if(src.getGauche()!=null)
            tabbutton[src.getGauche().getId()].setForeground(src.getGauche().getPion().getCouleur());

        if(src.getH_droite()!=null)
            tabbutton[src.getH_droite().getId()].setForeground(src.getH_droite().getPion().getCouleur());

        if(src.getH_gauche()!=null)
            tabbutton[src.getH_gauche().getId()].setForeground(src.getH_gauche().getPion().getCouleur());

        if(src.getDroite()!=null)
            tabbutton[src.getDroite().getId()].setForeground(src.getDroite().getPion().getCouleur());

        if(src.getB_droite()!=null)
            tabbutton[src.getB_droite().getId()].setForeground(src.getB_droite().getPion().getCouleur());

        if(src.getB_gauche()!=null)
            tabbutton[src.getB_gauche().getId()].setForeground(src.getB_gauche().getPion().getCouleur());

    }

    public JLabel setTitleName(){
        ArrayList<String> listJoueur = dc.getJoueur();
        int i=0;String html="<html> <div display='inline' align='center'>";
        for(String nom : listJoueur){
            html += "<font size='5'>"+nom+" : </font>";
            for (Color c : dc.getJcolor()[i]){
                if(c.equals(Color.black))
                    html += "<font color='black' size='3'> noir </font>";
                if(c.equals(Color.red))
                    html += "<font color='red' size='3'> rouge </font>";
                if(c.equals(Color.blue))
                    html += "<font color='blue' size='3'> bleu </font>";
                if(c.equals(Color.yellow))
                    html += "<font color='yellow' size='3'> jaune </font>";
                if(c.equals(Color.pink))
                    html += "<font color='pink' size='3'> violet </font>";
                if(c.equals(Color.green))
                    html += "<font color='green' size='3'> vert </font>";
            }
            html += "&nbsp;&nbsp;&nbsp;&nbsp;";
            i++;
        }
        html += "</div> </html>";
        JLabel label = new JLabel(html);
        label.setPreferredSize(new Dimension(500, 50));
        return label;
    }
}

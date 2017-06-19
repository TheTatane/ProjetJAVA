package View;

import BD.BaseDeDonees;
import BD.ThreadAddPlayer;
import MC.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;


public class Fenetre extends JFrame implements ActionListener {

	private int height;
	private int width;
	private String title;
    JPanel bg, topPanel, centerPanel;
    JButton bAbalone, bDameChinoise;
    CardLayout cl = new CardLayout();
    Menu menu = new Menu();
    DameChinoiseUI dameChinoiseUI;
    AbaloneUI abaloneUI;

    public Fenetre(){
        this.setTitle(this.title);
        this.setSize(900, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        menu.bSuivant.addActionListener(this);
        menu.bJouer.addActionListener(this);
        setContentPane(menu);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();

        // BOUTON JOUER, ON DECIDE QUEL JEU SERA LANCE
        if(object == menu.bJouer){

            /////////////////////////////////////////////////////////////////////////////////////
            // AFFICHER INTERFACE ABALONE
            if(menu.menuAbalone.isVisible()) {

                setSize(1100, 800);
                abaloneUI = new AbaloneUI(new Abalone());
                setContentPane(abaloneUI);
            }

            /////////////////////////////////////////////////////////////////////////////////////
            // AFFICHER INTERFACE DAME CHINOISE
            else if(menu.menuDameChinoise.isVisible()){

                DameChinoise dameChinoise = new DameChinoise(menu.nbJoueur, menu.nbColor, menu.mode);
                for(int i=0; i<menu.nbJoueur; i++){
                    dameChinoise.addJoueur(menu.joueurs[i]);
                }
                ThreadAddPlayer threadAddPlayer = new ThreadAddPlayer(menu.joueurs);
                threadAddPlayer.start();
                dameChinoise.setTourJoueur(dameChinoise.getJoueur().get(0));
                dameChinoiseUI = new DameChinoiseUI(dameChinoise);
                setSize(1100, 800);
                setContentPane(dameChinoiseUI);

                //bouton quitter
                dameChinoiseUI.btnBackMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContentPane(menu);
                        setSize(800, 400);
                    }
                });
            }
            setVisible(true);
        }
    }

}

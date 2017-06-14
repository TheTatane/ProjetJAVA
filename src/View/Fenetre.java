package View;

import MC.Abalone;
import MC.DameChinoise;
import MC.Jeux;
import MC.Plateau;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Fenetre extends JFrame implements ActionListener {

	private int height;
	private int width;
	private String title;
    JPanel bg, topPanel, centerPanel;
    JButton bAbalone, bDameChinoise;
    CardLayout cl = new CardLayout();
    Menu menu = new Menu();
    AbaloneUI abaloneUI;
    DameChinoiseUI dameChinoiseUI;
    Jeux jeu;

	public Fenetre(int W, int H, String T){
		height=H;
		width=W;
		title=T;
		this.setTitle(this.title);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

        // AFFICHE MENU
        menu.bSuivant.addActionListener(this);
        menu.menuAbalone.btn.addActionListener(this);
        menu.bJouer.addActionListener(this);
        setContentPane(menu);
        setVisible(true);
    }

    public Fenetre(){
        menu.bSuivant.addActionListener(this);
        menu.menuAbalone.btn.addActionListener(this);
        menu.bJouer.addActionListener(this);
        setContentPane(menu);
        setVisible(true);
    }

    public void setJeu(Jeux j){
        jeu=j;
        if(j.getClass() == DameChinoise.class)
            dameChinoiseUI = new DameChinoiseUI(jeu);
        if(j.getClass() == Abalone.class)
            abaloneUI = new AbaloneUI(jeu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object == menu.menuAbalone.btn){
            System.out.println("test");
        }

        if(object == menu.bSuivant){
            menu.cardLayout.next(menu.panelCard);
        }

        if(object == menu.bJouer){
            if(menu.menuAbalone.isVisible()) {
                setContentPane(abaloneUI);
            }
            else if(menu.menuDameChinoise.isVisible()){
                setContentPane(dameChinoiseUI);
                dameChinoiseUI.btnBackMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContentPane(menu);
                    }
                });
            }
            setVisible(true);
        }
    }

}

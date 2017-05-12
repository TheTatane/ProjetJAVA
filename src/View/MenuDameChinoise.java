package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class MenuDameChinoise extends JPanel implements ActionListener {

    JComboBox comboBoxJoueur, comboBoxMode;

    public MenuDameChinoise(){
        this.setBackground(Color.gray);
        this.setLayout(new FlowLayout());
        JLabel labelCombo = new JLabel("Nombre de joueurs : ");
        String strChoix[] = {"2J", "3J", "4J", "6J"};
        comboBoxJoueur = new JComboBox(strChoix);

        JLabel labelModeJeu = new JLabel("Mode de jeu : ");
        String str[] = {"MODE 1", "MODE 2", "MODE 3", "MODE YOUPI"};
        comboBoxMode = new JComboBox(str);
        this.add(labelCombo);
        this.add(comboBoxJoueur);
        this.add(labelModeJeu);
        this.add(comboBoxMode);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

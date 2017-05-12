package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class Menu extends JPanel implements ActionListener{

    MenuAbalone menuAbalone = new MenuAbalone();
    MenuDameChinoise menuDameChinoise = new MenuDameChinoise();
    JButton bSuivant=new JButton("SUIVANT");
    CardLayout cardLayout = new CardLayout();
    JPanel panelCard;
    BoutonJouer bJouer= new BoutonJouer();

    //////////////////////////////////////////////

    public Menu(){
        this.setLayout(new BorderLayout());
        panelCard = new JPanel();
        panelCard.setLayout(cardLayout);


        panelCard.add(menuAbalone);
        panelCard.add(menuDameChinoise);
        this.add(bSuivant, BorderLayout.WEST);
        this.add(panelCard, BorderLayout.CENTER);
        this.add(bJouer, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

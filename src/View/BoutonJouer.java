package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoutonJouer extends JButton {

    public BoutonJouer(){
        this.setBackground(Color.decode("#1A237E"));
        this.setText("Jouer");
        this.setBorderPainted(true);
        this.setForeground(Color.white);
        this.setBorderPainted(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#303F9F"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode("#1A237E"));
            }
        });
    }

}

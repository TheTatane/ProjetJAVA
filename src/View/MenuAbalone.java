package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class MenuAbalone extends JPanel implements ActionListener {

    JButton btn;

    public MenuAbalone(){
        this.setBackground(Color.darkGray);
        btn = new JButton("test");
        btn.addActionListener(this);
        this.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

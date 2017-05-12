package View;

import MC.DameChinoise;
import MC.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class DameChinoiseUI extends JPanel {

    public DameChinoiseUI(){
        this.setBackground(Color.cyan);
        //draw grid ?
    }

    public void draw(Plateau p){
        System.out.println("Dame chinoise draw");
    }
}

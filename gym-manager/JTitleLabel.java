package controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class JTitleLabel extends JLabel{
    public JTitleLabel(){
        setOpaque(false);
        setForeground(new java.awt.Color(0, 59, 70));
        setFont(new java.awt.Font("Tahoma", 3, 48));
    }
    protected void paintComponent(Graphics g){
        g.setColor(Color.white);
        super.paintComponent(g);
    }
}
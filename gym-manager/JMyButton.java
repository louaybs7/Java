
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;

public class JMyButton extends JButton {
    
    public JMyButton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(new Color(255, 255, 255));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        setBackground(new java.awt.Color(7, 87, 91));
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(70, 130, 180));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(0,0,102));
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class JMySectionButton extends JButton {
    
    public JMySectionButton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.white);
           setBackground(new java.awt.Color(7, 87, 91));
        setPreferredSize(new Dimension(140, 140));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Trebuche Ms", 1, 24));
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(70, 130, 180));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(Color.white);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
    
}

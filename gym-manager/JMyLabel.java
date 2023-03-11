
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JLabel;

public class JMyLabel extends JLabel {
    public JMyLabel(int size){
        setOpaque(false);
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, size));
    }
    protected void paintComponent(Graphics g){
        g.setColor(Color.white);
        super.paintComponent(g);
    }
}

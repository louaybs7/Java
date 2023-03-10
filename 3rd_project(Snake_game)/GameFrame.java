import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame {

    GameFrame(String s,Color c){
        GamePanel gp =new GamePanel(s,c);
        ImageIcon snake_icon = new ImageIcon("snake_face.png");
        Image Image = snake_icon.getImage();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Image);
        this.setTitle("Snake Game");
        this.setResizable(false);
        this.add(gp);
        this.pack();
        this.setVisible(true);

        }
    }


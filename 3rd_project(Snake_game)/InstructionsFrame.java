import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class InstructionsFrame extends JFrame implements ActionListener {
    JPanel InstructionsPanel    = new JPanel();
    JButton menu = new JButton ("Back to Menu ");

    InstructionsFrame() {
        ImageIcon snake_icon = new ImageIcon("snake_face.png");
        Image Image = snake_icon.getImage();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Image);
        this.setTitle("Snake Game");
        this.setResizable(false);
        //PreGamePane will let the Frame open in the center of the screen

        InstructionsPanel.setPreferredSize(new Dimension(500,500));
        InstructionsPanel.setBackground(new Color(0xAE6E4E));
        InstructionsPanel.setFocusable(true);
        InstructionsPanel.setLayout(null);

        JLabel inst = new JLabel("<html>"+"For the snake game , the objective is to eat all"+"<br/>"+"the apples that spawn randomly on the map."+"<br/>"+"you can control the Snake by arrow keys."+"<br/>"+"The more apples you eat the taller the snake is and the harder it gets."+"<br/>"+"You have to chose the path careful to not trap yourself in a closed spot ."+"<br/>"+"The game is considered a win if the snake covers the whole map and he hits his tail."+"<br/>"+"The score is calculated through apples, you eat one apple you get +1 in score and also +1 in Length."+"<html>");
        inst.setForeground(Color.white);
        inst.setFont(new Font("Verdana",Font.ITALIC,18));
        inst.setBounds(10,50,500,300);



        JLabel made = new JLabel("Game made by : Louay Ben Salah ");
        made.setForeground(Color.BLACK);
        made.setFont(new Font("Verdana",Font.ITALIC,15));
        made.setBounds(170,440,500,50);

        menu.setFocusable(false);
        menu.setBackground(Color.white);
        menu.addActionListener((ActionListener) this);
        menu.setBounds(0,450,150,30);

        InstructionsPanel.add(menu);
        InstructionsPanel.add(inst);
        InstructionsPanel.add(made);
        this.add(InstructionsPanel);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = "k";
        if(e.getSource()==menu){
            new MenuFrame();
            setVisible(false);
            dispose();
        }

    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuFrame extends JFrame implements ActionListener{
    JPanel MenuPanel = new JPanel();
    JButton startbutton = new JButton("START THE GAME ");
    JButton inst_button = new JButton("INSTRUCTIONS");
    JButton leaderboard_button = new JButton("LEADERBOARD");
    MenuFrame() {
        ImageIcon snake_icon = new ImageIcon("snake_face.png");
        Image Image = snake_icon.getImage();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Image);
        this.setTitle("Snake Game");
        this.setResizable(false);
        //PreGamePane will let the Frame open in the center of the screen

        MenuPanel.setPreferredSize(new Dimension(500,500));
        MenuPanel.setBackground(new Color(0xAE6E4E));
        MenuPanel.setFocusable(true);
        MenuPanel.setLayout(null);

        //buttons
        startbutton.setFocusable(false);
        startbutton.setBackground(Color.white);
        startbutton.addActionListener(this);
        startbutton.setBounds(150,150,200,50);
        inst_button.setFocusable(false);
        inst_button.setBackground(Color.white);
        inst_button.addActionListener(this);
        inst_button.setBounds(150,250,200,50);
        leaderboard_button.setFocusable(false);
        leaderboard_button.setBounds(150,350,200,50);
        leaderboard_button.setBackground(Color.white);
        leaderboard_button.addActionListener(this);
        //labels
        ImageIcon image = new ImageIcon("snake_face");
        JLabel title = new JLabel("WELCOME TO THE SNAKE GAME ");
        title.setFont(new Font("Arial",Font.BOLD,25));
        title.setForeground(Color.white);
        title.setIcon(image);
        title.setBounds(40,20,500,50);


        JLabel pic = new JLabel(new ImageIcon("snake_face.png"));
        pic.setPreferredSize(new Dimension(100,100));
        //panels
        MenuPanel.add(startbutton);
        MenuPanel.add(inst_button);
        MenuPanel.add(leaderboard_button);
        MenuPanel.add(title);
        MenuPanel.add(pic);
        this.add(MenuPanel);
        this.pack();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startbutton){
            new PreGameFrame();
            setVisible(false);
            dispose();
        }
        else if (e.getSource()==inst_button){
            new InstructionsFrame();
            setVisible(false);
            dispose();
        }
        else if (e.getSource()==leaderboard_button){
            new LeaderboardFrame();
            setVisible(false);
            dispose();
        }

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class PreGameFrame extends JFrame implements ActionListener {
        Color colora;
        JPanel PreGamePanel = new JPanel();
        JButton back = new JButton("Back to Menu");
        JButton next = new JButton("Start the Game");

        JButton chose_color = new JButton("Color");
        String user;
        JTextField username= new JTextField();
        PreGameFrame(){
            ImageIcon snake_icon = new ImageIcon("snake_face.png");
            Image Image = snake_icon.getImage();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setIconImage(Image);
            this.setTitle("Snake Game");
            this.setResizable(false);



            PreGamePanel.setPreferredSize(new Dimension(500,500));
            PreGamePanel.setBackground(new Color(0xAE6E4E));
            PreGamePanel.setFocusable(true);
            PreGamePanel.setLayout(null);

            chose_color.setFocusable(false);
            chose_color.setBackground(Color.white);
            chose_color.addActionListener(this);
            chose_color.setBounds(350,300,80,30);
            back.setFocusable(false);
            back.setBackground(Color.white);
            back.addActionListener(this);
            back.setBounds(0,450,150,30);
            next.setFocusable(false);
            next.setBackground(Color.white);
            next.addActionListener(this);
            next.setBounds(350,450,150,30);

            username.setText("Player");
            username.setFont(new Font("Consolas",Font.PLAIN,15));
            username.setForeground(Color.black);
            username.setBackground(Color.white);
            username.setBounds(250,150,200,40);

            JLabel fill = new JLabel("FILL BELOW TO START THE GAME :");
            fill.setForeground(Color.white);
            fill.setFont(new Font("Verdana",Font.ITALIC,25));
            fill.setBounds(40,20,500,50);
            JLabel color= new JLabel("Chose the color of the snake : ");
            color.setForeground(new Color(0x023020));
            color.setFont(new Font("Verdana",Font.PLAIN,20));
            color.setBounds(50,300,350,40);
            JLabel name = new JLabel("Add your name : ");
            name.setForeground(new Color(0x023020));
            name.setFont(new Font("Verdana",Font.PLAIN,20));
            name.setBounds(50,150,200,40);

            PreGamePanel.add(color);
            PreGamePanel.add(next);
            PreGamePanel.add(back);
            PreGamePanel.add(name);
            PreGamePanel.add(username);
            PreGamePanel.add(fill);
            PreGamePanel.add(chose_color);
            this.add(PreGamePanel);
            this.pack();
            this.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==back){
                new MenuFrame();
                setVisible(false);
                dispose();
            }
            else if (e.getSource()==next){
                user = username.getText();
                new GameFrame(user,colora);
                setVisible(false);
                dispose();
            }
            else if (e.getSource()==chose_color){
                JColorChooser colorChooser = new JColorChooser();
                colora = colorChooser.showDialog(null,"Pick a color",Color.GREEN);
                chose_color.setForeground(colora);
            }

        }
    }

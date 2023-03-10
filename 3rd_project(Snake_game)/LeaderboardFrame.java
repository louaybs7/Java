import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardFrame  extends JFrame implements ActionListener {
    JPanel LeaderboardPanel = new JPanel();
    JButton back = new JButton("Back to Menu");
    LeaderboardFrame() {
        ImageIcon snake_icon = new ImageIcon("snake_face.png");
        Image Image = snake_icon.getImage();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Image);
        this.setTitle("Snake Game");
        this.setResizable(false);
        //PreGamePane will let the Frame open in the center of the screen

        LeaderboardPanel.setPreferredSize(new Dimension(500, 500));
        LeaderboardPanel.setBackground(new Color(0xAE6E4E));
        LeaderboardPanel.setFocusable(true);
        LeaderboardPanel.setLayout(null);
        back.setFocusable(false);
        back.setBackground(Color.white);
        back.addActionListener(this);
        back.setBounds(0, 450, 150, 30);
        LeaderboardPanel.add(back);

        try {
            order();
            this.add(LeaderboardPanel);
            this.pack();
            this.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    void order() throws IOException {
        try {
            FileReader f = new FileReader("Leaderboard.txt");
            BufferedReader reader = new BufferedReader(f);
            ArrayList<Leader> LeaderRecords = new ArrayList<Leader>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] LeaderDetail = currentLine.split(" ");
                String name = LeaderDetail[0];
                int score = Integer.valueOf(LeaderDetail[1]);
                LeaderRecords.add(new Leader(name, score));
                currentLine = reader.readLine();

            }
            Collections.sort(LeaderRecords, Leader.scorecomparator);
            BufferedWriter writer = new BufferedWriter(new FileWriter("Leaderboard.txt"));
            for (Leader leader : LeaderRecords) {
                writer.write(leader.getName());

                writer.write(" " + leader.getScore());

                writer.newLine();
            }
            reader.close();
            writer.close();
            JLabel le = new JLabel("The Top 5 in Leaderboard : ");
            le.setForeground(Color.white);
            le.setFont(new Font("Verdana", Font.ITALIC, 30));
            le.setBounds(40,-50 , 450, 300);
            LeaderboardPanel.add(le);
            JTextArea display = new JTextArea(16, 400);
            display.setEditable(false); // set textArea non-editable
            display.setBackground(new Color(0xD79E75));

            for(int j=0;j<5;j++) {
                display.append(LeaderRecords.get(j).getName()+" "+LeaderRecords.get(j).getScore()+"\n");
            }
                display.setBounds(40, 200, 400, 200);
                display.setFont(new Font("Tahoma", Font.ITALIC, 30));
                LeaderboardPanel.add(display);

        }
         catch (Exception e) {

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s="s";
        if (e.getSource() == back) {
            new MenuFrame();
            setVisible(false);
            dispose();
        }
    }
}

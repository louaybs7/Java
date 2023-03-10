import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class GamePanel extends JPanel implements ActionListener{

     Snake snake;
     Apple apple;
     int Number_of_squares = 121;
     int Map_Length = 550;
     int Map_Height = 550;
     int SQUARE = 50;
     int DELAY = 150;
    boolean running = false;
    Timer timer;

    Color chosen;
    Color appleColor = new Color (0xADD8E6);
      String name;
    GamePanel(String s,Color c){
        name=s;
        chosen=c;
        this.setPreferredSize(new Dimension(Map_Length,Map_Height));
        this.setBackground(new Color(0xAE6E4E));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        snake =new Snake(this);
        apple= new Apple(20,20,snake,this);
        startGame();
    }
    public void startGame() {

        apple.AppleGen();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
            g.setColor(appleColor);
            g.fillOval(apple.x_coordinate_apple, apple.y_coordinate_apple, SQUARE, SQUARE);

            for(int i = 0; i< snake.getSnakeLength();i++) {
                if(i == 0) {
                    g.setColor(chosen);
                    g.fillOval(snake.x[i], snake.y[i], SQUARE, SQUARE);
                }
                else {
                    g.setColor(chosen);
                    g.fillRect(snake.x[i], snake.y[i], SQUARE, SQUARE);
                }
            }
            g.setColor(Color.white);
            g.setFont( new Font("Calibri",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+snake.getApplesEaten(), (Map_Length - metrics.stringWidth("Score: "+snake.getApplesEaten()))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont( new Font("Calibri",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+snake.getApplesEaten(), (Map_Length - metrics1.stringWidth("Score: "+snake.getApplesEaten()))/2, g.getFont().getSize());
        g.setColor(Color.white);
        g.setFont( new Font("Calibri",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (Map_Length - metrics2.stringWidth("Game Over"))/2, Map_Height/2);
        try
        {
            FileWriter writer = new FileWriter("Leaderboard.txt",true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(name+" "+snake.getApplesEaten());
            buffer.newLine();
            buffer.close();
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            snake.move();
            if((snake.x[0] == apple.x_coordinate_apple) && (snake.y[0] == apple.y_coordinate_apple)) {
                snake.incrementSnakeLength();
                snake.incrementApplesEaten();
                apple.AppleGen();
            }
           snake.checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_RIGHT && snake.direction !='L') {
            snake.headRight();
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN && snake.direction !='U') {
                snake.headDown();
            }
            if(e.getKeyCode()==KeyEvent.VK_LEFT && snake.direction !='R') {
                snake.headLeft();
            }
            if(e.getKeyCode()==KeyEvent.VK_UP && snake.direction !='D') {
                snake.headUp();
            }
            }
        }
    }

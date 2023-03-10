import javax.swing.*;
import java.awt.*;

public class Snake {
    GamePanel game;
    int x[];
    int y[];
    private int SnakeLength = 2;
    char direction = 'R';
    private int applesEaten;


    public Snake(GamePanel g ){
        game=g;
        x= new int[game.Number_of_squares];
        y= new int[game.Number_of_squares];
    }
    public void move(){
        for(int i = SnakeLength;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - game.SQUARE;
                break;
            case 'D':
                y[0] = y[0] + game.SQUARE;
                break;
            case 'L':
                x[0] = x[0] - game.SQUARE;
                break;
            case 'R':
                x[0] = x[0] + game.SQUARE;
                break;
        }

    }
    public void checkCollisions() {
        for (int i = SnakeLength; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                game.running = false;
            }
        }
        if (x[0] < 0) {
            game.running = false;
        }
        if (x[0] > game.Map_Length - 1) {
            game.running = false;
        }
        if (y[0] < 0) {
            game.running = false;
        }
        if (y[0] > game.Map_Height - 1) {
            game.running = false;
        }

        if (!game.running) {
            game.timer.stop();
        }
    }
    void setDirection(char c){
        direction=c;
    }
    void  headUp(){
        setDirection('U');
    }
    void headDown(){
        setDirection('D');
    }
    void headRight(){
        setDirection('R');
    }
    void headLeft(){
        setDirection('L');
    }

    public int getApplesEaten(){
        return applesEaten;
    }
    void incrementApplesEaten(){
         applesEaten++;
    }
    void incrementSnakeLength(){
        SnakeLength++;
    }
    public int getSnakeLength(){
        return SnakeLength;
    }
    public char getDirection(){
        return direction;
    }
    int getHeadxCoordinate(){
        return x[0];
    }
    int getHeadyCoordinate(){
        return y[0];
    }
}

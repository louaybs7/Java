import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Apple {

    Snake snake;
    GamePanel game;
    Random random = new Random();
    int x_coordinate_apple;
    int y_coordinate_apple;

    public Apple(int startX, int startY,Snake s,GamePanel g){
        snake=s;
        game=g;
        x_coordinate_apple=startX;
        y_coordinate_apple=startY;
    }

        public void AppleGen(){
            x_coordinate_apple = random.nextInt((int)(game.Map_Length/game.SQUARE))*game.SQUARE;
            y_coordinate_apple = random.nextInt((int)(game.Map_Height/game.SQUARE))*game.SQUARE;
            for (int i=0;i<snake.getSnakeLength();i++){
                if(snake.x[i]==x_coordinate_apple && snake.y[i]==y_coordinate_apple){
                    AppleGen();
                }
            }
        }
        int getX_coordinate_apple(){
        return x_coordinate_apple;
        }
        int getY_coordinate_apple(){
        return y_coordinate_apple;
    }

}

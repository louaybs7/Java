package fourgame;
import java.awt.Color;

public class Grill {
    private int score;
    private Color color;


    public Grill(){
        score = 0;
        color = null;
    }
    public void setColor(Color color) {
        if(color==null){
            this.color=null;
        }
        this.color = color;

    }
    public void setScore(int score) {
        this.score+=score;

    }
    public int getScore() {
        return score;
    }
    public Color getColor() {
        return color;
    }

}

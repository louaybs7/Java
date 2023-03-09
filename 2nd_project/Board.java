package fourgame;

import java.awt.Point;

public class Board {
    private Grill[][] board;
    private final int size;
    protected int countClick = 0;


    public Board(int size){
        this.size = size;
        board = new Grill[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j<this.size; j++){
                board[i][j]=new Grill();
            }
        }
    }

    public int getSize(){
        return this.size;

    }
    public Grill getField(int x, int y){
        return board[x][y];
    }
    public boolean GameOver(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j<this.size; j++){
                if(board[i][j].getColor()==null){
                    return false;
                }
            }
        }
        return true;
    }

    public Grill getField(Point p){
        return board[(int)p.getX()][(int)p.getY()];
    }


}

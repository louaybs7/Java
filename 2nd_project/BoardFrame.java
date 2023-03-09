package fourgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BoardFrame {
    private JButton[][] button;
    private Board board;
    private JPanel panel;



    public BoardFrame(int boardsize){
        board = new Board(boardsize);
        panel = new JPanel();
        panel.setLayout(new GridLayout(boardsize,boardsize));
        button = new JButton[boardsize][boardsize];
        for(int i=0;i<boardsize;i++){
            for(int j=0;j<boardsize;j++){
                JButton button = new JButton("0");
                button.addActionListener(new ButtonListener(i,j));
                button.setPreferredSize(new Dimension(80, 40));

                this.button[i][j]= button;
                panel.add(button);
            }
        }

    }

    public JPanel getBoardPanel() {
        return panel;
    }
    public void colorer(int x, int y, Color c){
        button[x][y].setBackground(c);
    }
    class ButtonListener implements ActionListener{
        private int x,y;
        public ButtonListener(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(board.getField(x,y).getColor()==null ){
                board.countClick++;
                for(int i=x-1;i<=x+1;i++){
                    if(i>=0 && i<board.getSize()){
                        if(board.getField(i,y).getScore()!=4 && board.getField(i,y).getColor()==null){
                            board.getField(i,y).setScore(1);
                            int score = board.getField(i, y).getScore();
                            button[i][y].setText(Integer.toString(score));
                            if(score==4){
                                if(board.countClick % 2 == 0){
                                  board.getField(i, y).setColor(Color.blue);
                                  colorer(i,y,Color.blue);
                                }
                                else{
                                  board.getField(i, y).setColor(Color.red);
                                  colorer(i,y,Color.red);
                                }

                            }
                        }
                        else if(board.getField(i,y).getColor()==null ){
                            if(board.countClick % 2 == 0){
                              board.getField(i, y).setColor(Color.blue);
                              colorer(i,y,Color.blue);
                            }
                             else{
                              board.getField(i, y).setColor(Color.red);
                              colorer(i,y,Color.red);
                            }
                        }


                    }
                }

                for(int j=y-1;j<=y+1;j++){
                    if(j>=0 && j<board.getSize() && j!=y){
                        if(board.getField(x,j).getScore()!=4  && board.getField(x,j).getColor()==null ){
                            board.getField(x,j).setScore(1);
                            int score = board.getField(x, j).getScore();
                            button[x][j].setText(Integer.toString(score));
                            if(score==4){
                                if(board.countClick % 2 == 0){
                                  board.getField(x, j).setColor(Color.blue);
                                  colorer(x,j,Color.blue);
                                }
                                else{
                                  board.getField(x, j).setColor(Color.red);
                                  colorer(x,j,Color.red);
                                }

                            }
                        }
                        else if(board.getField(x,j).getColor()== null ) {
                            if(board.countClick % 2 == 0){
                              board.getField(x, j).setColor(Color.blue);
                              colorer(x,j,Color.blue);
                            }
                            else{
                              board.getField(x, j).setColor(Color.red);
                              colorer(x,j,Color.red);
                            }
                        }

                    }

                }



            }
            if(board.GameOver()){
                int cntB = 0;
                int cntR = 0;
                for(int i = 0; i<board.getSize(); i++){
                    for(int j = 0; j<board.getSize(); j++){
                        if(board.getField(i,j).getColor()==Color.red){
                            cntR++;
                        }
                        else{
                            cntB++;
                        }
                    }
                }
                if(cntB>cntR){
                    JOptionPane.showMessageDialog(panel, "The blue player has won the game","Congrats",
                            JOptionPane.PLAIN_MESSAGE);
                    rest(board);



                }
                else if(cntR>cntB){
                    JOptionPane.showMessageDialog(panel, "The red player has won the game","Congrats",
                            JOptionPane.PLAIN_MESSAGE);
                    rest(board);


                }
                else{
                    JOptionPane.showMessageDialog(panel, "Nobody won the game.","TIE!",
                            JOptionPane.PLAIN_MESSAGE);
                    rest(board);


                }

            }
        }

    }
    public void rest(Board board){
        for(int i = 0; i<board.getSize(); i++){
            for(int j = 0; j<board.getSize(); j++){
                board.getField(i,j).setScore(-4);
                board.getField(i,j).setColor(null);
                button[i][j].setBackground(null);
                button[i][j].setText("0");
            }

        }

    }

}


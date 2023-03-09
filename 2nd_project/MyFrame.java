package fourgame;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MyFrame {
    private JFrame frame;
    private BoardFrame boardFrame;
    private final int Bsize = 3 ;


    public MyFrame(){
        ImageIcon image = new ImageIcon("tesla.jpg");
        frame=new JFrame("Mygame.louay");
        frame.setIconImage(image.getImage());
        frame.setBackground(new Color(0x123456));
        boardFrame = new BoardFrame(Bsize);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(boardFrame.getBoardPanel(),BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Help");
        menuBar.add(gameMenu);
        JMenu gameSize = new JMenu("size");
        menuBar.add(gameSize);

        int[] bSizes = {3,5,7};
        for(int size : bSizes){
            JMenuItem sizeMenu = new JMenuItem(size + "x"+size);
            gameSize.add(sizeMenu);
            sizeMenu.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().remove(boardFrame.getBoardPanel());
                    boardFrame = new BoardFrame(size);
                    frame.getContentPane().add(boardFrame.getBoardPanel(),BorderLayout.CENTER);
                    frame.pack();

                }
            });
        }
        JMenuItem gameExit = new JMenuItem("Exit");
        menuBar.add(gameExit);
        gameExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);

    }
}

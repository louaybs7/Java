/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalyfinal;

import java.util.*;
import java.io.*;
/**
 *
 * @author louay ben salah
 */
public class Info {
    private int NumberPlayer;
    private ArrayList<Gamer> gamers;
    private int fileds;
    private ArrayList<ClassField> classFields;
    private ArrayList<Integer> dice;
    private ArrayList<Gamer> thelosers;

    public Info() {
        this.gamers = new ArrayList<>();
        this.classFields = new ArrayList<>();
        this.dice = new ArrayList<>();
        this.thelosers = new ArrayList<>();
    }
    
    public void inputReading(String fileName) throws FileNotFoundException, InputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
        fileds = sc.nextInt();
        int j = 0;
        while(j < fileds) {
            ClassField f;
            switch(sc.next()) {
                case "PF":
                    f = new PropertyClassField();
                    classFields.add(f);
                    break;

                case "SF":
                    f = new ServiceClassField(sc.nextInt());
                    classFields.add(f);
                    break;
                case "LF":
                    f = new ClassFieldLucky(sc.nextInt());
                    classFields.add(f);
                    break;
                default:
                    throw new InputException("Problem with field input");
            }
            j++;
        }
        NumberPlayer = sc.nextInt();
        
        for (int i = 0; i < NumberPlayer; i++) {
            Gamer p;
            String name= sc.next();
            switch (sc.next()) {
                case "GP":
                    p = new GreedyGamer(name);
                    gamers.add(p);
                    break;
                case "CP":
                    p = new CarefulyP(name);
                    gamers.add(p);
                    break;
                case "TP":
                    p = new TacticalGamer(name);
                    gamers.add(p);
                    break;
                default:
                    throw new InputException("Problem with Player input");
            }
        }
        while (sc.hasNext()) {
            int i = sc.nextInt();
            while (i > fileds) {
                i -= fileds;
            }
            dice.add(i);
        }
    }
    
    public void simulation() {
        System.out.println("STARTING SIMULATION: TASK 5 (UOXP5R)");
        
        if (NumberPlayer <= 2) {
            System.out.println("More than 2 players are needed for this task. Exiting!");
            System.exit(-1);
        }
        // calculating rounds by dividing how many dices each player gets to play        
        int round = dice.size() / NumberPlayer;
        int turn = 0;
        
        for (int i = 1; i <= round; i++) {
            System.out.println("_______________\n" + (i) + ": ");
            for (Gamer p: gamers) {
                if (!p.isNeedy()) {
                    // if player can play, but the position is more than the fields given in text file,
                    // we start again from the first field = cyclic board
                    // player crosses start like on a monopoly board
                    if((p.getPosition() + dice.get(turn)) > fileds) {
                        p.setPosition((p.getPosition() + dice.get(turn)) - fileds);
                    } else {
                        // else keep increasing position on the board without crossing start for player
                        p.setPosition(p.getPosition() + dice.get(turn));
                    } 
                    // if a field gets stepped on keep playing as we would
                    if (classFields.get(p.getPosition()-1).getStepOn(p)) {
                        // do nothing
                    } else setfield(p); // otherwise a field is new and has no owner and no properties
                }
                // if player doesnt have money -> he has already lost
                else if (p.isNeedy()) {
                    thelosers.add(p);
                }
                turn++;
                System.out.println(p);
            }
            System.out.println("Round " + (i) + " ended");
        }
        // from losers get second loser
        if (thelosers.size() == 1) {
            System.out.println("In these dices, only 1 player lost.");
        } else if (thelosers.size() == 0) {
            System.out.println("There were no losers with the given dices.");
        } else System.out.println("Second loser: " + thelosers.get(1).getName());
    }
    
    public void setfield(Gamer p){
        p.hasBecomePoor();
        for(ClassField fil : classFields){
            if(fil.getTheOwner() == p){
                fil.setTheOwner(null);
                fil.setFields();
            }
        }
    }
    
}

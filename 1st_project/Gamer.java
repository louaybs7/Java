/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalyfinal;

/**
 *
 * @author louay ben salah
 */
public abstract class Gamer {
    protected int playerbalance;
    protected String name;
    protected int properties;
    protected boolean needy;
    protected int position;


    public Gamer(String name) {

        this.playerbalance = 10000;
        this.position = 0;
        this.properties = 0;
        this.needy = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayerbalance() {
        return playerbalance;
    }
    public int getProperties() {
        return properties;
    }

    public int getPosition() {
        return position;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public void setNeedy(boolean needy) {
        this.needy = needy;
    }

    public boolean isNeedy() {
        return needy;
    }

    public void setProperties(int properties) {
        this.properties = properties;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerbalance(int playerbalance) {
        this.playerbalance = playerbalance;
    }


    
    // Methods
    public void hasBecomePoor() {
        this.playerbalance = 0;
        this.properties = 0;
        this.needy = true;
    }

    public boolean couldGetHouse() {
        if (this.playerbalance >= 1000) return true;
        else return false;
    }



    

    public void getProperty(){
        this.properties++;
        this.playerbalance -= 1000;
    }
    public void addBalance(int fee) {
        this.playerbalance += fee;
    }

    @Override
    public String toString() {
        return ("PlqyerName: " + this.name + ", theBalance: " + this.playerbalance + ", Properties: " + this.properties);
    }
    
    
}

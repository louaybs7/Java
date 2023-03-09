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
public class TacticalGamer extends Gamer {
    
    private int sndChance;
            
    public TacticalGamer(String name) {
        super(name);
        this.sndChance = 0;
    }
    
    @Override
    public boolean couldGetHouse() {
        this.sndChance++;
        if ((this.playerbalance > 1000) && (this.sndChance % 2 != 0)) return true;
        else return false;
    }
    
}

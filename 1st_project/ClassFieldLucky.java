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
public class ClassFieldLucky extends ClassField {
    private int moneyEarnedByPlayer;

    public ClassFieldLucky(int moneyEarned) {
        super();
        this.moneyEarnedByPlayer = moneyEarned;
    }
    
    @Override
    public boolean getStepOn(Gamer p) {
        p.setPlayerbalance(p.getPlayerbalance() + this.moneyEarnedByPlayer);
        return true;
    }
    
    @Override
    public void setFields() {
        
    }
    
}

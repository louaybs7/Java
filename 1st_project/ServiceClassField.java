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
public class ServiceClassField extends ClassField {
    private int payTheBank;

    public ServiceClassField(int payTheBank) {
        super();
        this.payTheBank = payTheBank;
    }
    
    @Override
    public boolean getStepOn(Gamer p) {
        if(p.getPlayerbalance() > this.payTheBank) {
            p.setPlayerbalance(p.getPlayerbalance() - this.payTheBank);
            return true;
        } else return false;
    }
    
    @Override
    public void setFields() {
        
    }
}

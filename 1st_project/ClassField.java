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
public abstract class ClassField {
    protected Gamer theOwner;
    
    public ClassField() {
        
    }

    public ClassField(Gamer theOwner) {
        this.theOwner = theOwner;
    }

    public Gamer getTheOwner() {
        return theOwner;
    }

    public void setTheOwner(Gamer theOwner) {
        this.theOwner = theOwner;
    }
    
    public abstract void setFields();
    public abstract boolean getStepOn(Gamer gamer);
}

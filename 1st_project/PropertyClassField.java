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
public class PropertyClassField extends ClassField {
    protected boolean chekingHouseOwer = false;
    protected boolean checkHouse = false;

    public PropertyClassField() {
        super();
        this.theOwner = null;
    }
    
    public void isOwnedBy(Gamer p) {
        this.theOwner = p;
        this.chekingHouseOwer = true;
    }
    
    @Override
    public boolean getStepOn(Gamer gamer) {
        if(chekingHouseOwer && !checkHouse && theOwner != gamer){
            if(gamer.getPlayerbalance() >= 500){
                gamer.setPlayerbalance(gamer.getPlayerbalance() - 500);
                theOwner.setPlayerbalance(theOwner.getPlayerbalance() + 500);
            } else return false;
        } else if(chekingHouseOwer && checkHouse && theOwner != gamer){
            if(gamer.getPlayerbalance() >= 2000){
                gamer.setPlayerbalance(gamer.getPlayerbalance() - 2000);
                theOwner.setPlayerbalance(theOwner.getPlayerbalance() + 2000);
            } else return false;
        } else if(theOwner == gamer && !checkHouse && (gamer.getPlayerbalance() >= 4000)){
            gamer.setPlayerbalance(gamer.getPlayerbalance() - 2000);
            this.checkHouse = true;
        } else if(!chekingHouseOwer && gamer.couldGetHouse()){
            gamer.getProperty();
            isOwnedBy(gamer);
        }
        return true;
    }
    
    @Override
    public void setFields() {
        this.checkHouse = false;
        this.chekingHouseOwer = false;
    }
}

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
public class CarefulyP extends Gamer {

    public CarefulyP(String name) {
        super(name);
    }
    
    @Override
    public boolean couldGetHouse() {
        return (this.playerbalance > 1000)  && (this.playerbalance /2 > 1000);
    }    
}

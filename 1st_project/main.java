/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalyfinal;
import java.io.*;
import java.util.*;
/**
 *
 * @author louay ben salah
 * 
 */
public class Main {


    public static void main(String[] args) throws InputException {

        Info d = new Info();
        try {
            d.inputReading("t1.txt");
            d.simulation();
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found");
            System.exit(-1);
        } catch (NoSuchElementException x) {
            System.out.println("File Empty");
            System.exit(-1);
    }
    }
    
}

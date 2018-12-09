/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapi;

import com.sun.java.accessibility.util.GUIInitializedListener;

/**
 *
 * @author Shehab
 */
public class webapi {
    
    public static void main(String[] args) {
    findMyIP gui = new findMyIP();
    
    gui.setLocationRelativeTo(null);
    gui.setVisible(true);
    
    findipcontroller control = new findipcontroller(gui);
            //extendBorrowController extend_gui = new extendBorrowController(extendgui, r);

    }
    
}

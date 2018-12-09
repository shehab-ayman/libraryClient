/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapi;

import controller.FindBookContorller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmi.bookRemoteFacadeInterface;

/**
 *
 * @author Shehab
 */
public class findipcontroller {
    findMyIP gui;

    public findipcontroller(findMyIP gui) {
        this.gui = gui;
        
        
        gui.getjButton1().addActionListener(new getip());
    }

    class getip implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           
       // bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
        testip ip = new testip();
                try {
                    System.out.println(ip.getIPAdress());
                    gui.getjLabel3().setText(ip.getIPAdress());
                } catch (Exception ex) {
                    Logger.getLogger(findipcontroller.class.getName()).log(Level.SEVERE, null, ex);
                }
       
        
       

        }
    
    }
    
}

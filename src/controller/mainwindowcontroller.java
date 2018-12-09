/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmiclient.*;
import rmi.*;
/**
 *
 * @author Shehab
 */
public class mainwindowcontroller {
    bookMainWindow gui;
    Registry r;

    public mainwindowcontroller(bookMainWindow gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        gui.getjButton1().addActionListener(new nav1());
    }
    
    class nav1 implements ActionListener{
    
    @Override
    
    public void actionPerformed(ActionEvent ae) {
    
        try{
     bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
       //// bookRmiclient.findBookgui.setLocationRelativeTo(null); 
       // bookRmiclient.findBookgui.setVisible(false); 
          //     FindBookContorller findbook_gui = new FindBookContorller(bookRmiclient.findBookgui, r);

       //Registry r = LocateRegistry.getRegistry(1099);

        //bookRmiclient.findBookgui.setVisible(true);
        //Registry r = LocateRegistry.getRegistry(1099);
        //FindBookContorller gui_controller = new FindBookContorller(findBookgui, r);

        //findBook fb = new findBook();
        //fb.setVisible(true);
       //System.out.println("book is found!!!");
        
       
        
       }catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
    
    
    
    }
    
}

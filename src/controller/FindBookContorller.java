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
public class FindBookContorller {
    findBook gui;
    Registry r;

    public FindBookContorller(findBook gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        gui.getjButton1().addActionListener(new getName());
        gui.getjButton2().addActionListener(new getId());
    }
    
    class getName implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    
        try{
        bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
        
       String bookname =  gui.getjTextField1().getText();
       boolean result = b.findBookByName(bookname);
       if(result==true){
       //System.out.println("book is found!!!");
       JOptionPane.showMessageDialog(gui, "book is found");
       
       }
       else{
              JOptionPane.showMessageDialog(gui, "error occured");

       }
        
       }catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    }
    
    class getId implements ActionListener{
    
    
     @Override
    public void actionPerformed(ActionEvent ae) {
    
        try{
        bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
        
       String bookId =  gui.getjTextField1().getText();
       boolean result = b.findBookById(bookId);
       if(result==true){
       //System.out.println("book is found!!!");
       JOptionPane.showMessageDialog(gui, "book is found");
       
       }
        
       }catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    
    }
    
}

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
public class borrowBookController {
    borrowbookgui gui;
     Registry r;

    public borrowBookController(borrowbookgui gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
      gui.getjButton1().addActionListener(new borrow());
    }
     class borrow implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent ae) {
    
        try{
        bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
        String bookId = gui.getjTextField1().getText();
        String studentId = gui.getjTextField2().getText();
        boolean result = b.borrowBook(bookId, studentId);
        if(result==true){
               JOptionPane.showMessageDialog(gui, "book was borrowed successfully");

        }
        else{
                       JOptionPane.showMessageDialog(gui, "error happened during borrowal");

        }
        
       }catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
     
     
     }
     
}

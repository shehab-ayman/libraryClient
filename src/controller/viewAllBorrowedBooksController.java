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
public class viewAllBorrowedBooksController {
    ViewAllBorrowedBooks gui;
    Registry r;

    public viewAllBorrowedBooksController(ViewAllBorrowedBooks gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getjButton1().addActionListener(new getborrowedbooks());
        
    }
    
    class getborrowedbooks implements ActionListener{
    @Override
    
    public void actionPerformed(ActionEvent ae) {
    
        try{
        String studentid = gui.getjTextField1().getText();
        
        bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
        String list = b.getAllBorrowedBooks(studentid);
        gui.getjLabel5().setText(list);
        
       }catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
    
    
    
    
    }
    
}
}

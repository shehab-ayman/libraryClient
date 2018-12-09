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
public class extendBorrowController {
    extendBorrow gui;
    Registry r;

    public extendBorrowController(extendBorrow gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        gui.getjButton1().addActionListener(new extendborrow());
    }
        
        class extendborrow implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
                 bookRemoteFacadeInterface b =(bookRemoteFacadeInterface) r.lookup("bookSubSystem");
                 String studentId = gui.getjTextField1().getText();
                 String bookId = gui.getjTextField2().getText();
                 String extention = gui.getjTextField3().getText();
                
                boolean result =  b.extendBorrow(bookId, studentId, extention);
                
                if(result==true){
       //System.out.println("book is found!!!");
       JOptionPane.showMessageDialog(gui, "borrowal has been extended");
       
       }
       else{
              JOptionPane.showMessageDialog(gui, "error occured during borrowal extention");

       }
                }
                catch (RemoteException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FindBookContorller.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            
        
        
        }
    }
    
    
    
}



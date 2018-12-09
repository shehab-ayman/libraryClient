/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import controller.*;
/**
 *
 * @author Shehab
 */
public class bookRmiclient {
                  public static findBook findBookgui = new findBook();
                  public static borrowbookgui borrowbookgui = new borrowbookgui();
                  public static ViewAllBorrowedBooks allborrowedbooksgui = new ViewAllBorrowedBooks();
                  public static extendBorrow extendgui = new extendBorrow();
 public static void main(String[] args) throws RemoteException {
          bookMainWindow main = new bookMainWindow();
          
        findBookgui.setLocationRelativeTo(null); 
        findBookgui.setVisible(false); 
        borrowbookgui.setLocationRelativeTo(null);
        borrowbookgui.setVisible(false);
        allborrowedbooksgui.setLocationRelativeTo(null);
        allborrowedbooksgui.setVisible(false);
        extendgui.setLocationRelativeTo(null);
        extendgui.setVisible(false);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
       Registry r = LocateRegistry.getRegistry(1099);
        mainwindowcontroller gui_main = new mainwindowcontroller(main,r);
        FindBookContorller findbook_gui = new FindBookContorller(findBookgui, r);
        borrowBookController borrow_gui = new borrowBookController(borrowbookgui, r);
        viewAllBorrowedBooksController allborrow_gui = new viewAllBorrowedBooksController(allborrowedbooksgui, r);
        extendBorrowController extend_gui = new extendBorrowController(extendgui, r);
        
        
        //setfindBook();
        
    }
    public static void setfindBook(){
            findBookgui.setVisible(true); 
    }
    public static void setborrowbookgui(){
    borrowbookgui.setVisible(true);
    }
    public static void setViewAllBorrowedBooks(){
    allborrowedbooksgui.setVisible(true);
    }
    public static void extendBorrow(){
    extendgui.setVisible(true);
    }
}

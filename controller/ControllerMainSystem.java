
package controller;

import event.EventMenuSelected;
import event.EventPopupMenu;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;   
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import model.ModelUser;
import net.miginfocom.swing.MigLayout;
import swing.PopupMenu;
import view.component.MenuItem;
import view.main.component.PanelContent;
import view.main.component.content.GoodsInOut;
import view.main.component.content.Home;
import view.main.component.content.Products;

/**
 *
 * @author anhth
 */
public class ControllerMainSystem implements ActionListener, EventMenuSelected, EventPopupMenu{
    private PanelContent content;
    private Frame parent;
    private ModelUser user;

    public ControllerMainSystem(JLayeredPane bg, MigLayout layout, PanelContent content, ModelUser user) {
        this.content = content;
        this.user = user;
    }
    
    public ControllerMainSystem(java.awt.Frame parent){
        this.parent = parent;
    }
    
    public ControllerMainSystem(){}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void menuSelected(int menuIndex, int subMenuIndex) {
//        System.out.println("index: "+ menuIndex+ " sub index" + subMenuIndex);
//        System.out.println("user " + user.getUserName());
        if(menuIndex == 0) {
            if(subMenuIndex == -1){
                try {
                    content.showForm(new Home(user));
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMainSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(menuIndex == 1) {
            if(subMenuIndex == 0) {
                try {
                    content.showForm(new Products(user));
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMainSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(subMenuIndex == 1 || subMenuIndex == 2){
                GoodsInOut inout = new GoodsInOut(user);
                if(subMenuIndex == 1){
                    try {
                        inout.setType("import");
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerMainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        inout.setType("export");
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerMainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                content.showForm(inout);
            }
        } 
    }

    @Override
    public void showPopup(Component comp) {
        MenuItem item = (MenuItem) comp;
        PopupMenu popup = new PopupMenu(parent, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
        int x = parent.getX() + 52;
        int y = parent.getY() + comp.getY() + 86;
        popup.setLocation(x, y);
        popup.setVisible(true);
    }
    
}

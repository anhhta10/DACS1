package controller;

import event.EventMenu;
import event.EventPopupMenu;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import swing.menuAnimation;

/**
 *
 * @author anhth
 */
public class ControllerMenu implements EventMenu{
    
    private MigLayout layout;
    private boolean enableMenu;
    private boolean showMenu;
    private EventPopupMenu eventPopupMenu;

    
    public static void main(String[] args) {
       
    }

    public ControllerMenu(MigLayout layout, boolean enableMenu, boolean showMenu, EventPopupMenu eventPopupMenu) {
        this.layout = layout;
        this.enableMenu = enableMenu;
        this.showMenu = showMenu;
        this.eventPopupMenu = eventPopupMenu;
    }
    
    public ControllerMenu() {
        
    }
    
    @Override
    public boolean menuPressed(Component comp, boolean open) {
        if(enableMenu){
            if(showMenu){
                if(open) {
                    new menuAnimation(layout, comp).openMenu();
                } else {
                    new menuAnimation(layout, comp).closeMenu();
                }
                return true;
            } else {
                eventPopupMenu.showPopup(comp);
            }
        }
        return false;
    }
    
}

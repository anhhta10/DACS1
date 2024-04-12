
package view.main.component;

import controller.ControllerMenu;
import event.EventMenuSelected;
import event.EventMenu;
import event.EventPopupMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;
import swing.menuAnimation;
import view.component.MenuItem;

/**
 *
 * @author anhth
 */
public class PanelMenu extends javax.swing.JPanel {
    private final MigLayout layout;
    private EventMenuSelected eventSelected;
    private EventPopupMenu eventPopupMenu;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public void addEventPopupMenu(EventPopupMenu eventPopupMenu) {
        this.eventPopupMenu = eventPopupMenu;
    }

    public void addEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }
    
//    public 
    
    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public boolean isShowMenu() {
        return showMenu;
    }
    
    
    public PanelMenu() {
        initComponents();
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        
        setOpaque(false);
        sp.setViewportBorder(null);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBar());
        panel.setLayout(layout);
    }
    
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Home"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Kho hàng","Sản phẩm", "Nhập hàng", "Xuất hàng"));

        
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Đơn hàng", "Tất cả", "Đang xử lí", "Trả hàng", "Đã hủy"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Staff", "Sender", "Inbox", "User"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Our Centres"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/eye-off.png")), "Gallery"));
    }
    
    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), eventSelected, panel.getComponentCount()), "h 40!");
    }
    

    private EventMenu getEventMenu() {
        EventMenu event = new ControllerMenu(layout,enableMenu,showMenu,eventPopupMenu);
        
        return new EventMenu() {
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
        };
    }
    
    public void hideAllMenu() {
        for(Component com : panel.getComponents()){
            MenuItem item = (MenuItem) com;
            if(item.isOpen()) {
                new menuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        logo2 = new icon.Logo();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(4, 102, 200), getWidth(), 0, new Color(3, 83, 164));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        super.paintComponent(g);
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private icon.Logo logo2;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}

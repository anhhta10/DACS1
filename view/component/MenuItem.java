package view.component;

import event.EventMenu;
import event.EventMenuSelected;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import swing.MenuButton;

/**
 *
 * @author anhth
 */
public class MenuItem extends javax.swing.JPanel {

    private float alpha;
    private ModelMenu menu;
    private boolean open;
    private EventMenuSelected eventSelected;
    private int index;
    
    public ModelMenu getMenu() {
        return menu;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public EventMenuSelected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    public int getIndex() {
        return index;
    }
    
    public MenuItem(ModelMenu menu, EventMenu event, EventMenuSelected eventSelected, int index) {
        initComponents();
        this.menu = menu;
        this.eventSelected = eventSelected;
        this.index = index;
        setOpaque(false);
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
        MenuButton firstItem = new MenuButton(menu.getIcon(), 5, menu.getMenuName());
        firstItem.setForeground(Color.WHITE);
        firstItem.setFont(firstItem.getFont().deriveFont(Font.BOLD));
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(menu.getSubMenu().length > 0){
                    if(event.menuPressed(MenuItem.this, !open)){
                        open = !open;
                    }
                }
                eventSelected.menuSelected(index, -1);
            }
        });
        
        add(firstItem);
        int subMenuIndex = -1;
        for(String st : menu.getSubMenu()){
            MenuButton item = new MenuButton(st);
            item.setForeground(Color.WHITE);
            item.setIndex(++subMenuIndex);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventSelected.menuSelected(index, item.getIndex());
                }
            });
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        int height = getPreferredSize().height;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        Coler when open
        g2.setColor(new Color(2, 62, 125));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.fillRect(0, 0, getWidth(), 40);
        
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillRect(0, 40, getWidth(), height - 40);
        g2.setColor(new Color(0, 18, 51));
        g2.drawLine(30, 40, 30, height-17);
        for(int i = 0; i < menu.getSubMenu().length; i++){
            int y = ((i + 1)*35+40)-17;
            g2.drawLine(30, y, 38, y);
        }
        
        if(menu.getSubMenu().length > 0){
            createArrowButton(g2);
        }
        
        g2.setColor(new Color(3, 4, 94));
        g2.drawLine(0, height-1, getWidth(), height-1);
        super.paintComponent(g); 
    }
    
//    Icon tick
    private void createArrowButton(Graphics2D g2) {
        int size = 4;
        int y = 20;
        int x = 205;
        g2.setColor(new Color(230, 230, 230));
        float ay = alpha*size;
        float ay1 = (1f - alpha)*size;
        g2.drawLine(x,(int) (y + ay), x + 4,(int)(y + ay1));
        g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

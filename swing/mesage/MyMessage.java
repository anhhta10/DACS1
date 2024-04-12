/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing.mesage;

import java.awt.Color;
import javax.swing.Icon;
import swing.icon.GoogleMaterialDesignIcons;
import swing.icon.IconFontSwing;

/**
 *
 * @author anhth
 */
public class MyMessage extends javax.swing.JPanel {

public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;
    
    public MyMessage() {
        initComponents();
        setOpaque(false);
        setVisible(false);
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

    }
    
    public void showMessage(MessageType messageType,String title, String message) {
        this.messageType = messageType;
        lbTitle.setText(title);
        lbMessage.setText("<html>"+message+"</html>");
        Icon icon = null;
        
        if(messageType == MyMessage.MessageType.SUCCESS){
            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CHECK_CIRCLE, 30, new Color(110, 235, 131));
            tt.setBackground(new Color(110, 235, 131));
            sh.setShadowColor(new Color(110, 235, 131));
        } else if(messageType == MyMessage.MessageType.INFO){
            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INFO, 30, new Color(0, 80, 157));
            tt.setBackground(new Color(0, 80, 157));
            sh.setShadowColor(new Color(0, 80, 157));
        } else if(messageType == MyMessage.MessageType.WARNING) {
            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WARNING, 30, new Color(255, 179, 0));
            tt.setBackground(new Color(255, 179, 0));
            sh.setShadowColor(new Color(255, 179, 0));
        } else {
            icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ERROR, 30, new Color(239, 35, 60));
            tt.setBackground(new Color(239, 35, 60));
            sh.setShadowColor(new Color(239, 35, 60));
        }
        lbIcon.setIcon(icon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sh = new swing.showdow.PanelShadow();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();
        tt = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        sh.setRadius(10);
        sh.setShadowOpacity(0.5F);
        sh.setShadowSize(4);
        sh.setShadowType(swing.showdow.ShadowType.CENTER);

        lbIcon.setBackground(new java.awt.Color(255, 255, 255));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setOpaque(true);

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        tt.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ttLayout = new javax.swing.GroupLayout(tt);
        tt.setLayout(ttLayout);
        ttLayout.setHorizontalGroup(
            ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ttLayout.setVerticalGroup(
            ttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout shLayout = new javax.swing.GroupLayout(sh);
        sh.setLayout(shLayout);
        shLayout.setHorizontalGroup(
            shLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(shLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        shLayout.setVerticalGroup(
            shLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(shLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, shLayout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMessage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

//     @Override
//    protected void paintComponent(Graphics grphcs) {
//        Graphics2D g2 = (Graphics2D) grphcs;
//        if (messageType == MyMessage.MessageType.SUCCESS) {
//            g2.setColor(new Color(15, 174, 37));
//        } else {
//            g2.setColor(new Color(240, 52, 53));
//        }
//        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
//        g2.fillRect(0, 0, getWidth(), getHeight());
//        g2.setComposite(AlphaComposite.SrcOver);
//        g2.setColor(new Color(245, 245, 245));
//        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
//        super.paintComponent(grphcs);
//    }
//    
    public static enum MessageType {
        SUCCESS, ERROR, WARNING, INFO
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbTitle;
    private swing.showdow.PanelShadow sh;
    private javax.swing.JPanel tt;
    // End of variables declaration//GEN-END:variables
}

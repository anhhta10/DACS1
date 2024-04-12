/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author anhth
 */
public class PanelAction extends javax.swing.JPanel {

    public PanelAction() {
        initComponents();
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);    
    }
    
    public void initEvent(TableActionEvent event, int row) {
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onBtn1(row);
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onBtn2(row);
            }
        });

        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onBtn3(row);
            }
        });
    }
    
    public void showBtn(boolean btn1, boolean btn2, boolean btn3){
        this.btn1.setVisible(btn1);
        this.btn2.setVisible(btn2);
        this.btn3.setVisible(btn3); 
    }
    
    public void setIconBtn1(String src){
        btn1.setIcon(new ImageIcon(getClass().getResource(src)));
    }
    
    public void setIconBtn2(String src){
        btn2.setIcon(new ImageIcon(getClass().getResource(src)));
    }
    
    public void setIconBtn3(String src){
        btn3.setIcon(new ImageIcon(getClass().getResource(src)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new swing.table.ActionButton();
        btn2 = new swing.table.ActionButton();
        btn3 = new swing.table.ActionButton();

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus_24.png"))); // NOI18N

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_24.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.table.ActionButton btn1;
    private swing.table.ActionButton btn2;
    private swing.table.ActionButton btn3;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import model.ModelCard;

/**
 *
 * @author anhth
 */
public class PanelCard extends javax.swing.JPanel {

    private Color colorGradient;
    private Color borderColor;
    private int radius = 0;

    public PanelCard(Color colorGradient, Color borderColor, JLabel IbIcon, JLabel IbType, JLabel IbValues) {
        this.colorGradient = colorGradient;
        this.borderColor = borderColor;
        this.IbIcon = IbIcon;
        this.IbType = IbType;
        this.IbValues = IbValues;
    }
    public PanelCard() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        initComponents();
        setOpaque(false);
        setBackground(new Color(255, 255, 255));
        colorGradient =  getBackground();
    }

    public void setData(ModelCard data, String unit) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        IbType.setText(data.getType());
        IbValues.setText(df.format(data.getValues()) + unit);
        IbIcon.setIcon(data.getIcon());
    }
    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbIcon = new javax.swing.JLabel();
        IbValues = new javax.swing.JLabel();
        IbType = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        IbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        IbValues.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IbValues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IbValues.setText("0 đ");

        IbType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IbType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IbType.setText("Giá trị kho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(IbValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(IbType, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(IbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbValues)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbType)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius , radius);
        super.paintComponent(g);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbIcon;
    private javax.swing.JLabel IbType;
    private javax.swing.JLabel IbValues;
    // End of variables declaration//GEN-END:variables
}

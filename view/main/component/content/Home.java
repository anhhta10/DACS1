/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.main.component.content;

import controller.ControllerHome;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import model.ModelUser;
import swing.ScrollBar;


/**
 *
 * @author anhth
 */
public class Home extends javax.swing.JPanel {
    private ModelUser user;
    private MouseListener event;
    
    public Home(ModelUser user) throws SQLException {
        this.user = user;
        initComponents();
        setOpaque(false);
        bg.setViewportBorder(null);
        bg.getViewport().setOpaque(false);
        bg.setVerticalScrollBar(new ScrollBar());
        bg.setHorizontalScrollBar(new ScrollBar()); 
        init();
        initEvent();
    }
    
    private void init() {
        Card1.setBorderColor(Color.BLUE);
        Card1.setRadius(15);
        Shadow1.setShadowColor(Color.BLUE);

        Card2.setRadius(15);
        Card2.setBorderColor(Color.YELLOW);
        Shadow2.setShadowColor(Color.YELLOW);

        
        Card3.setBorderColor(Color.GREEN);
        Card3.setRadius(15);
        Shadow3.setShadowColor(Color.GREEN);

        
        Card4.setBorderColor(Color.ORANGE);
        Card4.setRadius(15);
        Shadow4.setShadowColor(Color.ORANGE);
    }

    private void initEvent() throws SQLException {
        event = new ControllerHome(user, Card1, Card2, Card3, Card4, chart);
        Card1.addMouseListener(event);
        Card2.addMouseListener(event);
        Card3.addMouseListener(event);
        Card4.addMouseListener(event);

    }
    
//    private void initCardData() throws SQLException {
//        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.HOME, 60, Color.BLUE);
//        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BOOK, 60, Color.YELLOW);
//        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WC, 60, Color.GREEN);
//        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WC, 60, Color.ORANGE);
//
//        InventorySummary iS = new ProductDAO().inventorySummary(user.getBusinessID());
//        
//        Card1.setData(new ModelCard("", "Giá trị kho", iS.getTotalInventory(),icon1), "đ");
//        Card1.setBorderColor(Color.BLUE);
//        Card1.setRadius(15);
//        
//        Card2.setData(new ModelCard("", "Số lượng", iS.getRemaing(), icon2), "");
//        Card2.setRadius(15);
//        Card2.setBorderColor(Color.YELLOW);
//        
//        Card3.setData(new ModelCard("", "Sản phẩm còn bán", iS.getAvailable(), icon3),"");
//        Card3.setBorderColor(Color.GREEN);
//        Card3.setRadius(15);
//        
//        Card4.setData(new ModelCard("", "Sản phẩm sắp hết", iS.getLowStock(), icon4),"");
//        Card4.setBorderColor(Color.ORANGE);
//        Card4.setRadius(15);
//
//    }
//    
//    private void initChartData() throws SQLException {
//        Stream<FinancialReport> stream = new PaymentDAO().revenue(user.getBusinessID());
//        
//        chart.addLegend("revenue", new Color(245, 189, 135));
//        chart.addLegend("profit", new Color(135, 189, 245));
//        chart.addLegend("loss", new Color(189, 135, 245));
//////        chart.addLegend("Cost", new Color(139, 229, 222));
////                chart.addData(new ModelChart(String.valueOf("a"), 200, 0, 100));
//
//        stream.forEach(s -> {
//            if(s.getProfit() > 0){
//                chart.addData(new ModelChart(String.valueOf(s.getDmy()), s.getRevenue(), s.getProfit()));
//            } else {
//                chart.addData(new ModelChart(String.valueOf(s.getDmy()), s.getRevenue(),0, -s.getProfit()));
//            }
//            
//        });
////        chart.addData(new ModelChart("February", 600, 700));
////        chart.addData(new ModelChart("March", new double[]{200, 350, 1000, 900}));
////        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
////        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
////        chart.addData(new ModelChart("June", new double[]{190, 500, 700, 1000}));
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        chart = new chart.Chart();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Shadow1 = new swing.showdow.PanelShadow();
        Card1 = new view.component.PanelCard();
        Shadow2 = new swing.showdow.PanelShadow();
        Card2 = new view.component.PanelCard();
        Shadow3 = new swing.showdow.PanelShadow();
        Card3 = new view.component.PanelCard();
        Shadow4 = new swing.showdow.PanelShadow();
        Card4 = new view.component.PanelCard();

        jLabel1.setText("Home");

        bg.setBorder(null);
        bg.setPreferredSize(new java.awt.Dimension(190, 100));

        jPanel1.setOpaque(false);

        chart.setPreferredSize(new java.awt.Dimension(585, 300));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Warehouse");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Statistical");

        Shadow1.setRadius(10);
        Shadow1.setShadowType(swing.showdow.ShadowType.CENTER);

        javax.swing.GroupLayout Shadow1Layout = new javax.swing.GroupLayout(Shadow1);
        Shadow1.setLayout(Shadow1Layout);
        Shadow1Layout.setHorizontalGroup(
            Shadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        Shadow1Layout.setVerticalGroup(
            Shadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Shadow2.setRadius(10);
        Shadow2.setShadowType(swing.showdow.ShadowType.CENTER);

        javax.swing.GroupLayout Shadow2Layout = new javax.swing.GroupLayout(Shadow2);
        Shadow2.setLayout(Shadow2Layout);
        Shadow2Layout.setHorizontalGroup(
            Shadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        Shadow2Layout.setVerticalGroup(
            Shadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Shadow3.setRadius(10);
        Shadow3.setShadowType(swing.showdow.ShadowType.CENTER);

        javax.swing.GroupLayout Shadow3Layout = new javax.swing.GroupLayout(Shadow3);
        Shadow3.setLayout(Shadow3Layout);
        Shadow3Layout.setHorizontalGroup(
            Shadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        Shadow3Layout.setVerticalGroup(
            Shadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        Shadow4.setRadius(10);
        Shadow4.setShadowType(swing.showdow.ShadowType.CENTER);

        javax.swing.GroupLayout Shadow4Layout = new javax.swing.GroupLayout(Shadow4);
        Shadow4.setLayout(Shadow4Layout);
        Shadow4Layout.setHorizontalGroup(
            Shadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        Shadow4Layout.setVerticalGroup(
            Shadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Shadow4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Card4, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Shadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Shadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Shadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Shadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Shadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Shadow3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Shadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Shadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bg.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(867, Short.MAX_VALUE))
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.PanelCard Card1;
    private view.component.PanelCard Card2;
    private view.component.PanelCard Card3;
    private view.component.PanelCard Card4;
    private swing.showdow.PanelShadow Shadow1;
    private swing.showdow.PanelShadow Shadow2;
    private swing.showdow.PanelShadow Shadow3;
    private swing.showdow.PanelShadow Shadow4;
    private javax.swing.JScrollPane bg;
    private chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

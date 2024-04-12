
package view.main.component.content;

import controller.InOut.ControllerInOut;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import model.ModelUser;

/**
 *
 * @author anhth
 */
public class GoodsInOut extends javax.swing.JPanel {
    private ModelUser user;
    private ActionListener event;
    private String type;
    
    public GoodsInOut(ModelUser user) {
        initComponents();
        this.user = user;
        init();
    }

    private void init() {
        txtSearch.setHint("Search");
        txtSearch.setSuffixIcon(new ImageIcon(getClass().getResource("/icon/search_24.png")));
        table.fixTable(jScrollPane1);
//        table.setAlignRender(true);
        btnAdd.setHover(new Color(0, 0, 0, 0.1f));
        btnRemove.setHover(new Color(0, 0, 0, 0.1f));
        btnUpdate.setHover(new Color(0, 0, 0, 0.1f));
        table.setCantEdit(0,0,0,0,0,0,0,0);
    }
    
    public void setType(String type) throws SQLException {
        this.type = type;
        initEvent();
    }
    
    private void initEvent() throws SQLException {
        event = new ControllerInOut(user, table, type);
        btnAdd.addActionListener(event);
        btnDetail.addActionListener(event);
        btnRemove.addActionListener(event);
        btnUpdate.addActionListener(event);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new swing.showdow.PanelShadow();
        txtSearch = new swing.TextField();
        btnAdd = new swing.Button();
        btnUpdate = new swing.Button();
        btnRemove = new swing.Button();
        btnDetail = new swing.Button();
        jLabel2 = new javax.swing.JLabel();
        panelShadow2 = new swing.showdow.PanelShadow();
        panelShadow3 = new swing.showdow.PanelShadow();
        txtFilter = new javax.swing.JLabel();
        panelShadow4 = new swing.showdow.PanelShadow();
        btnFilterDate = new swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        panelShadow1.setEnabled(false);
        panelShadow1.setRadius(10);
        panelShadow1.setShadowType(swing.showdow.ShadowType.CENTER);

        btnAdd.setText("Add New");
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnRemove.setText("Delete");
        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnDetail.setText("Detail");
        btnDetail.setFocusPainted(false);
        btnDetail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel2.setText("Warehouses / Import");

        panelShadow2.setRadius(10);
        panelShadow2.setShadowType(swing.showdow.ShadowType.CENTER);

        panelShadow3.setBackground(new java.awt.Color(221, 221, 221));
        panelShadow3.setRadius(10);
        panelShadow3.setShadowSize(2);
        panelShadow3.setShadowType(null);

        txtFilter.setBackground(new java.awt.Color(255, 255, 255));
        txtFilter.setText("All");
        txtFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        txtFilter.setOpaque(true);

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFilter)
                .addContainerGap())
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFilter)
                .addContainerGap())
        );

        panelShadow4.setRadius(10);
        panelShadow4.setShadowSize(2);
        panelShadow4.setShadowType(swing.showdow.ShadowType.CENTER);

        btnFilterDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/flter_24.png"))); // NOI18N

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnFilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnFilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnAdd;
    private swing.Button btnDetail;
    private swing.Button btnFilterDate;
    private swing.Button btnRemove;
    private swing.Button btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.showdow.PanelShadow panelShadow1;
    private swing.showdow.PanelShadow panelShadow2;
    private swing.showdow.PanelShadow panelShadow3;
    private swing.showdow.PanelShadow panelShadow4;
    private swing.table.Table table;
    private javax.swing.JLabel txtFilter;
    private swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

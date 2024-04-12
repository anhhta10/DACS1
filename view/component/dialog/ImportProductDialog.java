package view.component.dialog;

import controller.InOut.ControllerIn;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import model.ModelUser;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author anhth
 */
public class ImportProductDialog extends javax.swing.JDialog {
    private final JFrame fram;
    private ModelUser user;
    private ActionListener event;
    private String typeDialog;
    private String typeBill;
    private boolean result = false;
    private MigLayout layout;
    
    public ImportProductDialog(JFrame fram, ModelUser user) throws SQLException{
        super(fram, true);
        this.fram = fram;
        this.user = user;
        initComponents();
        init();
    }
    
    public void init() throws SQLException {
        setLocationRelativeTo(fram);
        setResizable(false);
        table1.fixTable(jScrollPane1);
        table2.fixTable(jScrollPane2);
        layout = new MigLayout("fill, insets 0");
        bg.setLayout(layout);
        
        initEvent();
    }
    
    public void initEvent() throws SQLException {
        event = new ControllerIn(user,this, bg, layout, table1, table2);
    }
    
    public void showDialog() {
        setVisible(true);
    }

    public boolean isResult() {
        return result;
    }
    
    public void setData() {
        
    }
    
    public void setResult(boolean result) {
        this.result = result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new swing.showdow.PanelShadow();
        panelShadow3 = new swing.showdow.PanelShadow();
        txtSearch = new swing.TextField();
        panelShadow12 = new swing.showdow.PanelShadow();
        btnFilterDate = new swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();
        panelShadow2 = new swing.showdow.PanelShadow();
        panelShadow13 = new swing.showdow.PanelShadow();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbbPayer = new swing.combobox.ComboBoxSuggestion();
        txtDue = new javax.swing.JLabel();
        txtPerformer = new swing.TextField();
        panelShadow14 = new swing.showdow.PanelShadow();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        cbbSupplier = new swing.combobox.ComboBoxSuggestion();
        txtSupplier = new swing.TextField();
        txtpaid = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new swing.table.Table();
        panelShadow10 = new swing.showdow.PanelShadow();
        btnCamcel = new swing.Button();
        btnReset = new swing.Button();
        btnOk = new swing.Button();
        btnDelete = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelShadow1.setBgColor(new java.awt.Color(204, 204, 204));
        panelShadow1.setRadius(10);
        panelShadow1.setShadowColor(new java.awt.Color(0, 0, 102));
        panelShadow1.setShadowType(swing.showdow.ShadowType.CENTER);

        panelShadow3.setRadius(10);
        panelShadow3.setShadowType(swing.showdow.ShadowType.CENTER);

        panelShadow12.setRadius(10);
        panelShadow12.setShadowSize(2);
        panelShadow12.setShadowType(swing.showdow.ShadowType.CENTER);

        btnFilterDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/flter_24.png"))); // NOI18N

        javax.swing.GroupLayout panelShadow12Layout = new javax.swing.GroupLayout(panelShadow12);
        panelShadow12.setLayout(panelShadow12Layout);
        panelShadow12Layout.setHorizontalGroup(
            panelShadow12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnFilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        panelShadow12Layout.setVerticalGroup(
            panelShadow12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnFilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ".NO", "ID", "Name", "Remaining", "Price", "Quantity", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(40);
            table1.getColumnModel().getColumn(0).setPreferredWidth(40);
            table1.getColumnModel().getColumn(0).setMaxWidth(40);
            table1.getColumnModel().getColumn(1).setMinWidth(45);
            table1.getColumnModel().getColumn(1).setPreferredWidth(45);
            table1.getColumnModel().getColumn(1).setMaxWidth(45);
            table1.getColumnModel().getColumn(2).setPreferredWidth(180);
            table1.getColumnModel().getColumn(3).setPreferredWidth(70);
            table1.getColumnModel().getColumn(4).setPreferredWidth(100);
            table1.getColumnModel().getColumn(5).setPreferredWidth(60);
            table1.getColumnModel().getColumn(6).setMinWidth(40);
            table1.getColumnModel().getColumn(6).setPreferredWidth(40);
            table1.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShadow2.setBgColor(new java.awt.Color(204, 204, 204));
        panelShadow2.setRadius(10);
        panelShadow2.setShadowType(swing.showdow.ShadowType.CENTER);

        panelShadow13.setRadius(10);
        panelShadow13.setShadowType(swing.showdow.ShadowType.CENTER);

        jPanel2.setOpaque(false);

        jLabel1.setText("Performer");

        jLabel2.setText("Payer");

        jLabel3.setText("Total amount due");

        jSeparator1.setOpaque(true);

        txtDue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtPerformer.setEditable(false);
        txtPerformer.setBackground(new java.awt.Color(234, 234, 234));
        txtPerformer.setForeground(new java.awt.Color(65, 65, 65));
        txtPerformer.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtPerformer.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        txtPerformer.setSelectionColor(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbPayer, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtPerformer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtDue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPerformer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbbPayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtDue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow13Layout = new javax.swing.GroupLayout(panelShadow13);
        panelShadow13.setLayout(panelShadow13Layout);
        panelShadow13Layout.setHorizontalGroup(
            panelShadow13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow13Layout.setVerticalGroup(
            panelShadow13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShadow14.setRadius(10);
        panelShadow14.setShadowType(swing.showdow.ShadowType.CENTER);

        jPanel3.setOpaque(false);

        jLabel4.setText("Supplier");

        jLabel5.setText("New Supplier");

        jSeparator2.setOpaque(true);

        jLabel6.setText("total amount paid");

        txtpaid.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtpaid.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(txtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelShadow14Layout = new javax.swing.GroupLayout(panelShadow14);
        panelShadow14.setLayout(panelShadow14Layout);
        panelShadow14Layout.setHorizontalGroup(
            panelShadow14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow14Layout.setVerticalGroup(
            panelShadow14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ".NO", "ID", "Name", "Quantity", "Unit price", "Total", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setMinWidth(40);
            table2.getColumnModel().getColumn(0).setPreferredWidth(40);
            table2.getColumnModel().getColumn(0).setMaxWidth(40);
            table2.getColumnModel().getColumn(1).setMinWidth(45);
            table2.getColumnModel().getColumn(1).setPreferredWidth(45);
            table2.getColumnModel().getColumn(1).setMaxWidth(45);
            table2.getColumnModel().getColumn(2).setPreferredWidth(198);
            table2.getColumnModel().getColumn(3).setPreferredWidth(60);
            table2.getColumnModel().getColumn(4).setPreferredWidth(80);
            table2.getColumnModel().getColumn(5).setPreferredWidth(80);
            table2.getColumnModel().getColumn(6).setMinWidth(40);
            table2.getColumnModel().getColumn(6).setPreferredWidth(40);
            table2.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        panelShadow10.setRadius(10);
        panelShadow10.setShadowType(swing.showdow.ShadowType.CENTER);

        btnCamcel.setBackground(new java.awt.Color(255, 102, 102));
        btnCamcel.setForeground(new java.awt.Color(255, 255, 255));
        btnCamcel.setText("Cancel");
        btnCamcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnReset.setText("Reset");

        btnOk.setBackground(new java.awt.Color(102, 102, 255));
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("Ok");
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");

        javax.swing.GroupLayout panelShadow10Layout = new javax.swing.GroupLayout(panelShadow10);
        panelShadow10.setLayout(panelShadow10Layout);
        panelShadow10Layout.setHorizontalGroup(
            panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCamcel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        panelShadow10Layout.setVerticalGroup(
            panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow10Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCamcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow2Layout.createSequentialGroup()
                        .addComponent(panelShadow13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelShadow13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(panelShadow10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bg.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private swing.Button btnCamcel;
    private swing.Button btnDelete;
    private swing.Button btnFilterDate;
    private swing.Button btnOk;
    private swing.Button btnReset;
    private swing.combobox.ComboBoxSuggestion cbbPayer;
    private swing.combobox.ComboBoxSuggestion cbbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private swing.showdow.PanelShadow panelShadow1;
    private swing.showdow.PanelShadow panelShadow10;
    private swing.showdow.PanelShadow panelShadow12;
    private swing.showdow.PanelShadow panelShadow13;
    private swing.showdow.PanelShadow panelShadow14;
    private swing.showdow.PanelShadow panelShadow2;
    private swing.showdow.PanelShadow panelShadow3;
    private swing.table.Table table1;
    private swing.table.Table table2;
    private javax.swing.JLabel txtDue;
    private swing.TextField txtPerformer;
    private swing.TextField txtSearch;
    private swing.TextField txtSupplier;
    private javax.swing.JLabel txtpaid;
    // End of variables declaration//GEN-END:variables
}


package swing.table;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.util.stream.Stream;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;




/**
 *
 * @author anhth
 */
public class Tabl extends javax.swing.JPanel {

    private DefaultTableModel model;
    
    public Tabl() {
        FlatLaf.registerCustomDefaultsSource("swing");
        FlatMacLightLaf.setup();
        initComponents();
        applyTableStyle(tb);
        model = (DefaultTableModel) tb.getModel();
    }
    
    public Tabl(Object[] cols, Object[] data) {
        FlatLaf.registerCustomDefaultsSource("swing");
        FlatMacLightLaf.setup();
        initComponents();
        applyTableStyle(tb);
        model = (DefaultTableModel) tb.getModel();
        setCols(cols);
        setData(data);
    }
    
    public void setCols(Object[] cols) {
        model.setColumnIdentifiers(cols);
    }
    
    public void setData(Object[] data){
        model.addRow(data);
    }
    
    private void applyTableStyle(JTable table){
        JScrollPane scroll = (JScrollPane) table.getParent().getParent();
//        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(ui, table);
        table.setSelectionBackground(new Color(0,0,0,0.1f));
        table.setSelectionForeground(Color.BLACK);
    }
    
    public void setAlignRender(boolean align){
        if(align){
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tb.setDefaultRenderer(Object.class, centerRenderer);
        }
    }
   
    public void setCell(int n){
        tb.setDefaultRenderer(Object.class,getCellRender(tb.getDefaultRenderer(Object.class), n-1));
    }
    
    private TableCellRenderer getCellRender(TableCellRenderer oldRenderer, int i){
        return new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = oldRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(com instanceof JLabel){
                    JLabel label = (JLabel) com;
                    if(column == i) {
                        if(Double.parseDouble(value.toString()) <= 0) {
                            com.setForeground(new Color(243,99,99));
                            label.setText(value+"");
                        }else {
                            com.setForeground(new Color(0,212,27));
                            label.setText("+" + value);
                        }
                    } else {
                        com.setForeground(table.getForeground());
//
//                        if(isSelected){
////                            com.setForeground(table.);
//                        } else {
//                        }
                    }
                }
                return com;
            }
        };
    }
    
    public JTable getTable(){
        return tb;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();

        tb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}

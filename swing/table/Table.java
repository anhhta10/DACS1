package swing.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import swing.ScrollBarCustom;

public class Table extends JTable {
    private int cols[];
    private int conditions[];
    private String strings[];
    private int[] canEdit;
    
    private boolean center = false;
    
    public Table() {
        getTableHeader().setDefaultRenderer(new TableHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new TableCell());
        setRowHeight(30);
        
        DefaultTableModel model = new NonEditableTableModel(new Object[][] {} ,new Object[] {});
        setModel(model);
    }
    
//======================= Override model ======================
    
    private boolean isCellEditorTable(int column) {
        if(canEdit != null){
            if(canEdit.length >= getColumnCount()){
                return canEdit[column] == 1;
            }
        }
//        System.out.println(canEdit[column] == 1);

        return true;
    }
    
    private class NonEditableTableModel extends DefaultTableModel {

        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return isCellEditorTable(column);
        }
    }
//  ===========================================================
    
    public void setCantEdit(int... canEdit){
        this.canEdit = canEdit;
    }
    public int getL(){
        return canEdit.length;
    }

    public void fixTable(JScrollPane scroll){
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(2, 62, 138));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(255, 255, 255));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
        setSelectionForeground(Color.BLACK);
    }
    
    public void setAlignRender(boolean align){
        if(align){
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            setDefaultRenderer(Object.class, centerRenderer);
            this.center = true;
        }
    }
    
    public void ColCheck(int[] conditions, String[] strings, int... cols){
        this.cols = cols;
        this.conditions = conditions;
        this.strings = strings;
    }
    
    private class TableHeader extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(3, 4, 94));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            
            if(center) {
                setHorizontalAlignment(JLabel.CENTER);
            }
            
            return com;
        }        
    }
    
    private class TableCell extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if(isSelected){
                com.setBackground(new Color(173, 181, 189));
            } else{
                 if(row%2 == 0){
                com.setBackground(new Color(248, 249, 250));
                } else {
                    com.setBackground(new Color(222, 226, 230));
                }
            }
            
            com.setForeground(table.getForeground());
            if(cols != null){
                int index = 0;
                for(int col:cols){
                   JLabel label = (JLabel) com;
                    if(column == col) {
                        if(Double.parseDouble(value.toString()) <= conditions[index]) {
                            com.setForeground(new Color(243,99,99));
                            label.setText(value+"");
                        }else {
                            com.setForeground(new Color(0,212,27));
                            label.setText(strings[index] + value);
                        }
                    }
                }
            }
            
            setBorder(new EmptyBorder(0,5,0,5));
            return com;
        } 
    }

    @Override
    protected TableColumnModel createDefaultColumnModel() {
        return new DefaultTableColumnModel() {
            @Override
            public void moveColumn(int columnIndex, int newIndex) {
            }
        };
    }
}

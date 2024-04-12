package swing.table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author anhth
 */
public class TableActionCellEditor extends DefaultCellEditor{
    private boolean btn1, btn2, btn3;
    private String icon1, icon2,icon3;
    private TableActionEvent event;
    
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();

        action.showBtn(btn1, btn2, btn3);
        if(icon1 != null){
            action.setIconBtn1(icon1);
        }
        if(icon2 != null){
            action.setIconBtn2(icon2);
        }
        
        if(icon3 != null){
            action.setIconBtn3(icon3);
        }
        
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
    
    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public void setIcon3(String icon3) {
        this.icon3 = icon3;
    }
    
    public void showBtn(boolean btn1, boolean btn2, boolean btn3){
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
    }
    
}

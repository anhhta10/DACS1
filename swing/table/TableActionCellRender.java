
package swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author anhth
 */
public class TableActionCellRender extends DefaultTableCellRenderer{

    private boolean btn1, btn2, btn3;

    private String icon1, icon2,icon3;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
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

        if(isSelected == false && row % 2 == 0){
            action.setBackground(Color.WHITE);
        } else {
            
            action.setBackground(com.getBackground());
        }

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

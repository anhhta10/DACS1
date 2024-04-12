
package swing.table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;
import swing.spinner.Spinner;
import swing.spinner.SpinnerUI;

/**
 *
 * @author anhth
 */
public class SpinnerCell extends DefaultCellEditor {
    private EventCellInputChange event = null;
    private Spinner input;
    private JTable table;
    private int row;
    private int col1 = -1;
    private int col2 = -1;
    
    public SpinnerCell() {
        super(new JCheckBox());
        input = new Spinner();

        SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(0); // set minimun value for input
        
        input.addChangeListener((ChangeEvent e) -> {
            inputChange();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        this.table = table;
        this.row = row;
        
        int qty = Integer.parseInt(value.toString());
        input.setValue(qty);
        return input;
    }

    @Override
    public Object getCellEditorValue() {
        return input.getValue();
    }
    
    private void inputChange() {
        int qty = Integer.parseInt(input.getValue().toString());
        if(col1 !=-1 && col2 != -1){
            int value1 = Integer.parseInt(table.getValueAt(row, col1).toString());
            table.setValueAt(value1*qty, row, col2);
            if(event != null){
                event.inputChanged();
            }
        }
    }
    
    public void setCols(int col1, int col2){
//    col2 = colSpinner * col1;
        this.col1 = col1;
        this.col2 = col2;
    }
    
    public void addEvent(EventCellInputChange event){
        this.event = event; 
    }
}

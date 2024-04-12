package controller.InOut;

import DAO.InOutDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;
import model.ModelProductInOut;
import model.ModelUser;
import swing.table.Table;
import view.component.dialog.ImportProductDialog;

/**
 *
 * @author anhth
 */
public class ControllerInOut implements ActionListener{
    private ModelUser user;
    private Table table;
    private String type;
    private Object[] ob;
    private String typeId;
    
    public ControllerInOut(ModelUser user, Table table, String type) throws SQLException {
        this.user = user;
        this.table = table;
        this.type = type;
        String person = "";
        if(type.equals("import")){
            person = "Payer";
            this.typeId = "IP";
        } else {
            person = "Collector";
            this.typeId = "XP";
        }
        ob = new Object[] {".NO", "Id", "Amount", "Date", "Time", "Performer", person, "Description"};
        initData();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(type.equals("import")){
            ImportProductDialog dialog;
            if(command.equals("Add New")){
                try {
                    dialog = new ImportProductDialog(null,user);
                    dialog.showDialog();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInOut.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    private void initData() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        Stream<ModelProductInOut> bills = new InOutDAO().getInOut(user.getBusinessID(), type);
        model.setColumnIdentifiers(ob);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(4);
        table.getColumnModel().getColumn(1).setPreferredWidth(4);
        table.getColumnModel().getColumn(1).setMinWidth(45);
        
        model.setRowCount(0);
        
        int[] no = {0};
        bills.forEach(bill -> {
            ++no[0];
            model.addRow(new Object[]{
                no[0],
                this.typeId+bill.getId(),
                bill.getAmount(),
                bill.getDate(),
                bill.getTime(),
                bill.getPerformer(),
                typeId.equals("IP") ? bill.getPayer(): bill.getCollector(),
                bill.getDescription()
            });
        
        });
    }
}

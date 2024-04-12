
package controller;

import DAO.ProductDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import model.ModelProduct;
import model.ModelUser;
import swing.TextField;
import swing.combobox.ComboBoxSuggestion;
import swing.table.Table;
import view.component.dialog.ProductDialog;

public class ControllerProduct implements ActionListener{
    private Table table;
    private ModelUser user;
    private Object[] ob;
    private String typeDialog = "";
    private TextField txtName;
    private TextField txtPrice;
    private TextField txtPurchase;
    private TextField txtUnit; 
    private TextField txtCategory;
    private ComboBoxSuggestion cbbCategory;
    private ComboBoxSuggestion cbbUnit;
    private ModelProduct modelProduct;
    private JTextArea txtDes;
    private ProductDAO dao;
    private ProductDialog dialog;
    private int productId = -1;
    
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher;
    
    public ControllerProduct(ModelUser user, Table table) throws SQLException {
        this.user = user;
        this.table = table;
        ob = new Object[] {".No","Id", "Product Name", "Price", "PurchasePrice", "Quantity", "Unit", "Category", "Description"};
        initDataTable();
    }
    
    public ControllerProduct
        (
            ModelUser user, ProductDialog dialog, String typeDialog, TextField txtName,
            TextField txtPrice, TextField txtPurchase, 
            TextField txtUnit, TextField txtCategory, 
            ComboBoxSuggestion cbbCategory, ComboBoxSuggestion cbbUnit,
            JTextArea txtDes, int productId
        ) throws SQLException
    {
        this.user = user;
        this.dialog = dialog;
        this.typeDialog = typeDialog;
        this.txtName = txtName;
        this.txtPrice = txtPrice;
        this.txtPurchase = txtPurchase;
        this.txtUnit = txtUnit;
        this.txtCategory = txtCategory;
        this.cbbCategory = cbbCategory;
        this.cbbUnit = cbbUnit;
        this.txtDes = txtDes;
        this.productId = productId;
        initCBB();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
    //============================= Add New =================================
        if(command.equals("Add New")){
            try {
                dialog = new ProductDialog(null, user, command, productId);
                dialog.showDialog();
                
                if(dialog.isResult()){
                    initDataTable();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    //============================= Update =================================
        else if(command.equals("Update")){
            try {
                int row = table.getSelectedRow();
                
                if(row != -1){
                    System.out.println(table.getValueAt(row, 1));
                    matcher = pattern.matcher(String.valueOf(table.getValueAt(row, 1)));
      
                    String string = matcher.find() ? matcher.group() : "";
                    
                    productId = Integer.parseInt(string);
                    dialog = new ProductDialog(null, user, command, productId);
                    initDataDialog();
                    dialog.showDialog();
                
                    if(dialog.isResult()){
                        initDataTable();
                    }   
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    //============================= Delete =================================        
        else if(command.equals("Delete")) {
            try {
                deleteData();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    //============================= Dialog event =================================        
        else if(command.equals("OK")) {
            if(typeDialog.equals("Add New")){
                try {
                    addNewData();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(typeDialog.equals("Update")){
                try {
                    updateData();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
//============================== Init Data Table ========================================================================    
    private void initDataTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //get data from database
        Stream<ModelProduct> products = new ProductDAO().getProducts(user.getBusinessID());

        //set column
        model.setColumnIdentifiers(ob);
        table.getColumnModel().getColumn(0).setPreferredWidth(4);
        table.getColumnModel().getColumn(1).setPreferredWidth(4);
        table.getColumnModel().getColumn(1).setMinWidth(45);

        //reset table        
        model.setRowCount(0);
        int[] no = {0};
        //push data into table
        products.forEach((product) -> {
            ++no[0];
            model.addRow(new Object[] {
                no[0],
                "PD"+product.getId(),
                product.getName(),
                product.getPrice(),
                product.getPurchasePrice(),
                product.getStock(),
                product.getUnit(),
                product.getCategory(),
                product.getDescription()
            });
        });
    }
    
//============================== Init Data Dialog ========================================================================
    private void initDataDialog() throws SQLException {
        dao = new ProductDAO();
        ModelProduct products = new ProductDAO().getProducts(user.getBusinessID(), productId); 
        this.dialog.setData(products);
    }
    
//============================== Init ComboBox ========================================================================    
    private void initCBB() throws SQLException{
        //get data from database
        dao = new ProductDAO();
        List<String> categories = dao.getCategories(user.getBusinessID());
        List<String> units = dao.getUnits(user.getBusinessID());

        //push data into combobox
        for(String category : categories){
            System.out.println(category);
            cbbCategory.addItem(category);
        }
        
        for(String unit : units){
            cbbUnit.addItem(unit);
        }
    }
    

//============================== Add New Data ========================================================================    
    private void addNewData() throws SQLException, SQLException, SQLException {
        String name = txtName.getText().trim();
        String price = txtPrice.getText().trim();
        String purchase = txtPurchase.getText().trim();
        String unit = String.valueOf(cbbUnit.getSelectedItem());
        String category = String.valueOf(cbbCategory.getSelectedItem());
        String unitTxt = txtUnit.getText().trim();
        String categoryTxt = txtCategory.getText().trim();
        String des = txtDes.getText();
        
        if(des.isEmpty()){
            des = "";
        }
        
        
        if(name.isEmpty()){
            
            txtName.setBorder(true);
            txtName.repaint();
        }

        if(price.isEmpty()){
            txtPrice.setBorder(true);
            txtPrice.repaint();
        }
        
        if(purchase.isEmpty()){
            txtPurchase.setBorder(true);
            txtPurchase.repaint();
        }
        
        if(!name.isEmpty()) {
            if(!price.isEmpty()){
                if(!purchase.isEmpty()){
                    txtPurchase.setBorder(false);
                    txtPurchase.repaint();
                    if(!unitTxt.isEmpty()) {
                        if(!categoryTxt.isEmpty()){
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unitTxt,
                                    categoryTxt,
                                    des
                                );
                            
                            dao = new ProductDAO();
                            dao.insertItem(user.getBusinessID(), modelProduct); 
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        } else {
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unitTxt,
                                    category,
                                    des
                                );
                            
                            dao = new ProductDAO();
                            dao.insertItem(user.getBusinessID(), modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        }
                    } else {
                        if(!categoryTxt.isEmpty()){
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unit,
                                    categoryTxt,
                                    des
                                );
                            dao = new ProductDAO();
                            dao.insertItem(user.getBusinessID(), modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        } else {
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unit,
                                    category,
                                    des
                                );
                            dao = new ProductDAO();
                            dao.insertItem(user.getBusinessID(), modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        }
                    }
                } else {
                    txtPurchase.requestFocus();
                    txtPrice.setBorder(false);
                    txtPrice.repaint();
                }
            } else {
                txtPrice.requestFocus();
                txtName.setBorder(false);
                txtName.repaint();
            }
        } else {
            txtName.requestFocus();
        }
    }

//============================== Update Data ========================================================================    
    private void updateData() throws SQLException {
        String name = txtName.getText().trim();
        String price = txtPrice.getText().trim();
        String purchase = txtPurchase.getText().trim();
        String unit = String.valueOf(cbbUnit.getSelectedItem());
        String category = String.valueOf(cbbCategory.getSelectedItem());
        String unitTxt = txtUnit.getText().trim();
        String categoryTxt = txtCategory.getText().trim();
        String des = txtDes.getText();
        
        if(des.isEmpty()){
            des = "";
        }
        
        if(name.isEmpty()){
            
            txtName.setBorder(true);
            txtName.repaint();
        }

        if(price.isEmpty()){
            txtPrice.setBorder(true);
            txtPrice.repaint();
        }
        
        if(purchase.isEmpty()){
            txtPurchase.setBorder(true);
            txtPurchase.repaint();
        }
        
        if(!name.isEmpty()) {
            if(!price.isEmpty()){
                if(!purchase.isEmpty()){
                    txtPurchase.setBorder(false);
                    txtPurchase.repaint();
                    if(!unitTxt.isEmpty()) {
                        if(!categoryTxt.isEmpty()){
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unitTxt,
                                    categoryTxt,
                                    des
                                );
                            
                            dao = new ProductDAO();
                            dao.updateData(user.getBusinessID(), productId, modelProduct); 
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        } else {
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unitTxt,
                                    category,
                                    des
                                );
                            
                            dao = new ProductDAO();
                            dao.updateData(user.getBusinessID(), productId, modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        }
                    } else {
                        if(!categoryTxt.isEmpty()){
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unit,
                                    categoryTxt,
                                    des
                                );
                            dao = new ProductDAO();
                            dao.updateData(user.getBusinessID(), productId, modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        } else {
                            modelProduct = new ModelProduct(
                                    name, 
                                    Double.parseDouble(price),
                                    Double.parseDouble(purchase),
                                    unit,
                                    category,
                                    des
                                );
                            dao = new ProductDAO();
                            dao.updateData(user.getBusinessID(), productId, modelProduct);
                            this.dialog.setResult(true);
                            this.dialog.dispose();
                        }
                    }
                } else {
                    txtPurchase.requestFocus();
                    txtPrice.setBorder(false);
                    txtPrice.repaint();
                }
            } else {
                txtPrice.requestFocus();
                txtName.setBorder(false);
                txtName.repaint();
            }
        } else {
            txtName.requestFocus();
        }
    }
  
//============================== Update Data ========================================================================    
    private void deleteData() throws SQLException{
        
        System.out.println("Tạo thêm các điều kiện kiểm tra như:");
        System.out.println("Có đơn hàng nào đang chứa sản phẩm này không (2 trường hợp đã thanh toán và chưa thanh toán)");
        System.out.println("Kiểm tra các ràng buộc liên quan khác...");

//        int row = table.getSelectedRow();
//        if(row != -1){
//            productId = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
//            dao = new ProductDAO();
//            dao.deleteData(user.getBusinessID(), productId);
//        }
    }
    
}

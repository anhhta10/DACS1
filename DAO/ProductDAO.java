
package DAO;

import connection.DTBCS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import model.InventorySummary;
import model.ModelProduct;

/**
 *
 * @author anhth
 */
public class ProductDAO {
    private Connection con;
    
    public void insertItem(int id, ModelProduct model) throws SQLException{
        con = DTBCS.getConnection();
        String sql = "INSERT INTO `sales`.`items` " +
                        "(`name`, `price`, `purchasePrice`, `unit`, " +
                        "`category`, `description`, `businessId`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, model.getName());
        pst.setDouble(2, model.getPrice());
        pst.setDouble(3, model.getPurchasePrice());
        pst.setString(4, model.getUnit());
        pst.setString(5, model.getCategory());
        pst.setString(6, model.getDescription());
        pst.setInt(7, id);

        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        rs.first();
        int productId = rs.getInt(1);
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        model.setId(productId);
    }

    public void deleteData(int id, int productId) throws SQLException {
        con = DTBCS.getConnection();
        
        String sql = "delete from `items` where (`id` = ?) and (`businessId` = ?);";
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, productId);
        pst.setInt(2, id);
        pst.executeUpdate();
        
        pst.close();
        DTBCS.closeConnection(con);
    } 
    
    public void updateData(int id, int productId, ModelProduct model) throws SQLException{
        con = DTBCS.getConnection();
        
        String sql = "update items "+
                    "set `name` = ?, `price` = ?, `purchasePrice` = ?, "+
                        "`category` = ?, `unit` = ?, `description` = ? "+
                    "where (`id` = ?) and (`businessId` = ?);";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, model.getName());
        pst.setDouble(2, model.getPrice());
        pst.setDouble(3, model.getPurchasePrice());
        pst.setString(4, model.getCategory());
        pst.setString(5, model.getUnit());
        pst.setString(6, model.getDescription());
        pst.setInt(7, productId);
        pst.setInt(8, id);

        pst.executeUpdate();
        pst.close();
        DTBCS.closeConnection(con);
    }
    
    
    public InventorySummary inventorySummary(int id) throws SQLException {
        con = DTBCS.getConnection();
        int remaing = 0;
        int available = 0;
        double totalInventory = 0;
        int lowStock = 0;
        InventorySummary iS;
        
        String sql = "with InventorySummary AS ( " +
                        "select sum(Items.stock) AS remaining, "+
                            "count(*) AS available, "+
                            "sum(Items.price * Items.stock) AS totalInventory "+
                        "from Items "+
                        "join BusinessOwners ON Items.businessId = BusinessOwners.id "+
                        "where BusinessOwners.id = ? "+
                    ") select remaining, available, "+
                            "(select count(*) from Items where stock < 10 and businessId = ?) AS lowStockCount, "+
                            "totalInventory "+
                    "from InventorySummary;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setInt(2, id);

        
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            remaing = rs.getInt(1);
            available = rs.getInt(2);
            lowStock = rs.getInt(3);
            totalInventory = rs.getDouble(4);
        }
        iS = new InventorySummary(remaing, available, totalInventory, lowStock);
        
        rs.close();
        DTBCS.closeConnection(con);
        return iS;
    }
    
    public Stream<ModelProduct> getProducts(int id) throws SQLException{
        con = DTBCS.getConnection();
        Stream<ModelProduct> item = null;
        List itemList = new ArrayList();
        
        String sql = "select id, name, description, price, purchasePrice, stock, category, unit from items where businessId = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        
        ResultSet rs = pst.executeQuery();
    
        while(rs.next()) {
            int ProductId = rs.getInt(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            double price = rs.getDouble(4);
            double PP = rs.getDouble(5);
            int stock = rs.getInt(6);
            String category = rs.getString(7);
            String unit = rs.getString(8);
            
            itemList.add(new ModelProduct(ProductId, name, price, PP, stock, unit, category, description));
        }
        
        item = itemList.stream();
        
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        
        return item;
    }
    
    public ModelProduct getProducts(int id, int productId) throws SQLException{
        con = DTBCS.getConnection();
        
        String sql = "select * from items where businessId = ? and id = ? limit 1";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, id);
        pst.setInt(2, productId);
        ModelProduct model = null;
        ResultSet rs = pst.executeQuery();
    
        if(rs.next()) {
            int ProductId = rs.getInt(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            double price = rs.getDouble(4);
            double PP = rs.getDouble(5);
            int stock = rs.getInt(6);
            String category = rs.getString(7);
            String unit = rs.getString(8);
            
            model = new ModelProduct(ProductId, name, price, PP, stock, unit, category, description);
        }
        
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        
        return model;
    }    
    
    public List<String> getCategories(int id) throws SQLException {
        con = DTBCS.getConnection();
        List<String> categories = new ArrayList<>();
        
        String sql = "select distinct category " +
                        "from items " +
                     "where businessId = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
            categories.add(rs.getString(1));
        }
        
        DTBCS.closeConnection(con);
        return categories;
    }
    
    public List<String> getUnits(int id) throws SQLException {
        con = DTBCS.getConnection();
        List<String> units = new ArrayList<>();
        
        String sql = "select distinct unit " +
                        "from items " +
                      "where businessId = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            units.add(rs.getString(1));
        }
        
        DTBCS.closeConnection(con);
        return units;
    }
}
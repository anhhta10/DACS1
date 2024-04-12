
package DAO;

import connection.DTBCS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import model.FinancialReport;
import model.InventorySummary;

/**
 *
 * @author anhth
 */
public class PaymentDAO {
    private Connection con;
    
    public Stream revenue(int id) throws SQLException {
        con = DTBCS.getConnection();

        
        Stream<FinancialReport> stream;
        List ls = new ArrayList();
        
        String sql = "SELECT " +
                        "paymentDate, "+ 
                        "DAY(paymentDate) AS paymentDay, "+
                        "MONTH(paymentDate) AS paymentMonth, "+
                        "YEAR(paymentDate) AS paymentYear, "+
                        "SUM(amount) AS daily_revenue, " +
                        "p.profit "+
                    "FROM Payments "+
                    "left join ( "+
                        "select "+
                            "orders.finishDate, "+
                            "sum(total* (1 - IFNULL(vouchers.discountAmount, 0))) as profit " +
                        "from orders "+
                        "join ( "+
                            "select " +
                            "orderdetails.orderId, " +
                            "(sum((orderdetails.price*(1 - IFNULL(discounts.discountAmount, 0)) - orderdetails.quantity*items.purchasePrice))) as total "+
                        "from orderdetails " +
                        "join orders on orders.id = orderdetails.orderId and orders.businessId = orderdetails.businessId " +
                        "join items on items.id = orderdetails.itemID  and items.businessId = orderdetails.businessId " +
                        "left join discounts on discounts.itemId = orderdetails.itemId and discounts.businessId = orderdetails.businessId "+
                        "where orderdetails.businessId = ? " +
                        "group by orderdetails.orderId " +
                    ") as i on i.orderId = orders.id " +
                    "left join vouchers on vouchers.orderId = orders.id and vouchers.businessId = orders.businessId " +
                    "where orders.businessId = ? " +
                    "group by orders.finishDate " +
                    ") as p on p.finishDate = paymentDate "+
                "where businessId = ? " +
                "GROUP BY paymentDate, paymentYear, paymentMonth, paymentDay, p.profit " +
                "ORDER BY paymentDate, paymentYear, paymentMonth, paymentDay;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setInt(2, id);
        pst.setInt(3, id);
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            ls.add(new FinancialReport(
                    rs.getDate(1).toLocalDate(),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getDouble(6)
            ));
        }
        
//        ls.sort(Comparator.comparing(ModelRevenue::getDmy));  
        stream = ls.stream();
        
        rs.close();
        DTBCS.closeConnection(con);
        return stream;
    }
}

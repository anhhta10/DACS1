package DAO;

import connection.DTBCS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import model.ModelProductInOut;

/**
 *
 * @author anhth
 */
public class InOutDAO {
    private Connection con;
    
    
    public Stream<ModelProductInOut> getInOut(int id, String type) throws SQLException {
        con = DTBCS.getConnection();
        Stream<ModelProductInOut> bills = null;
        List billsList = new ArrayList();
        
        String sql = "select " +
                        "pi.id, pi.amount, " +
                        "date(date) as date, time(date) as time, " +
                        "up.name as payer, uc.name as collector, " +
                        "uper.name as performer, description " +
                    "from productinout pi " +
                    "left join users up on pi.payerId = up.id and up.businessId = ? " +
                    "left join users uc on pi.collectorId = uc.id and uc.businessId = ? " +
                    "left join users uper on pi.performerId = uper.id and uper.businessId = ? " +
                    "where pi.businessId = ? and pi.type = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setInt(2, id);
        pst.setInt(3, id);
        pst.setInt(4, id);
        pst.setString(5, type);
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            billsList.add(
                new ModelProductInOut(
                    rs.getInt(1),
                    rs.getDouble(2),
                    rs.getDate(3).toLocalDate(), 
                    rs.getTime(4).toLocalTime(),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                )
           );
        }
        
        bills = billsList.stream();
        return bills;
    }
}

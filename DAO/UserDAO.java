
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DTBCS;
import model.ModelUser;

public class UserDAO {
    private Connection con;
    
    public synchronized void insertUser(ModelUser user) throws SQLException {
        con = DTBCS.getConnection();
        String sql;
        PreparedStatement pst;
        int id;
        
        sql = "insert into `businessowners` (`ownerName`) values (?)";
        pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, user.getUserName());
        
        pst.execute();
        ResultSet rs1 = pst.getGeneratedKeys();
        
        rs1.first();
        id = rs1.getInt(1);
        rs1.close();
        
        sql = "insert into `users` (name, email, `password`, role, businessId) values (?,?,?,?,?)" ;
        
        pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, user.getUserName());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setString(4, "business owners");
        pst.setInt(5, id);

        pst.execute();
        ResultSet rs2 = pst.getGeneratedKeys();
        
        rs2.first();
        int userID = rs2.getInt(1);
        rs2.close();
        pst.close();
        DTBCS.closeConnection(con);
        user.setUserID(userID);
        user.setBusinessID(id);
    }
    
    public void updatePass(String email, String pass) throws SQLException {
        
        con = DTBCS.getConnection();
        
        String sql = "UPDATE `users` SET `password` = ? WHERE (BINARY(email)= ?) limit 1";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, pass);        
        pst.setString(2, email);
        
        pst.executeUpdate();
        pst.close();
        DTBCS.closeConnection(con);        
    }
    
    public boolean checkDuplicateEmail(String user) throws SQLException {
        con = DTBCS.getConnection();
        boolean duplicate = false;
        String sql = "select id from `users` where email=? limit 1";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            duplicate = true;
        }
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        DTBCS.closeConnection(con);
        return duplicate;
    }
        
    public ModelUser login(ModelUser login) throws SQLException{
        con = DTBCS.getConnection();
        
        ModelUser data = null;
        String sql = "select id, name, email, businessId from `users` where BINARY(email)= ? and BINARY(`password`)= ? limit 1";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, login.getEmail());
        pst.setString(2, login.getPassword());

        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            int userID = rs.getInt(1);
            String userName = rs.getString(2);
            String email = rs.getString(3);
            int businessId = rs.getInt(4);
            data = new ModelUser(userID, userName, email, businessId);
        }
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        return data;
    }
    
    public boolean checkGmail(String email) throws SQLException {
        boolean gmail = false;
        
        con = DTBCS.getConnection();
        
        String sql = "select id from `users` where BINARY(email)= ? limit 1";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            gmail = true;
        }
        rs.close();
        pst.close();
        DTBCS.closeConnection(con);
        return gmail;
    }
}

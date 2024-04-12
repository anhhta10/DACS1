package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DTBCS {
    public static Connection getConnection() {
        Connection c = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mySQL://localhost:3306/sales";
            String userName = "root";
            String pass = "123456789";
            
            c = DriverManager.getConnection(url, userName, pass);
            System.out.println(c.getMetaData().getDatabaseProductName());

        } catch (SQLException ex) {
            Logger.getLogger(DTBCS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void closeConnection(Connection c){
        try {
            if(c != null){
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

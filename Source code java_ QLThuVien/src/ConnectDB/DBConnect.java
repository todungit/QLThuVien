package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; encrypt=true; trustServerCertificate=true;";
            String user = "sa";
            String pass = "SA";
            connection = DriverManager.getConnection(url, user, pass);
            System.err.println("thanh cong");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return connection;
    }

    /*
        String connectionUrl = "jdbc:sqlserver://DESKTOP-DRIHG7H\\SQLEXPRESS:1433;DatabaseName=QLTV; user=sa; password=SA ;encrypt=true;trustServerCertificate=true;";

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Sach";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("MaSach") + " " + rs.getString("TenSach"));
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

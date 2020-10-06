import java.sql.*;
public class JDBC_demo{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //loading driver
        // Class.forName("com.mysql.jdbc.Driver");
        // Interface
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ST","root","root");
        // Interface
        Statement stmt = cnn.createStatement(); //createStatement is non static method.
        ResultSet rs = stmt.executeQuery("Select * from Students");
        while(rs.next()){
            System.out.println(rs.getString("Names"));
        }
        cnn.close();
    }
}

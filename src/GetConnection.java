import jdk.nashorn.internal.objects.annotations.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/callable_demo_db";
    private static final String userURL = "root";
    private static final String passwordURL = "admin123";
    public Connection getConnectDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, userURL, passwordURL);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        GetConnection getConnection = new GetConnection();
        if (getConnection.getConnectDB() != null){
            System.out.println("ok");
        } else {
            System.out.println("bad");
        }
    }
}

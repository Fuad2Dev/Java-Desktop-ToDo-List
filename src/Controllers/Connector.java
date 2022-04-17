package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public static Connection connection = null;
    boolean isConnected = false;

    String dbURL = "jdbc:mysql://localhost:3306/todo";
    String username = "root";
    String password = "compssavotingsystem";

    public Connector(){
        connect();
    }

    public boolean connect(){
        try {
            connection = DriverManager.getConnection(dbURL, username, password);

            if (connection != null) {
                isConnected = true;
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            System.out.println("not connected");
        }

        return isConnected;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        new Connector().connect();
    }

}

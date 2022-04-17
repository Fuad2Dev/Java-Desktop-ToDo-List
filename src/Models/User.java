package Models;

import Controllers.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    static int user_id;

    public boolean create(String user_name, String password) {
        String sql = "INSERT INTO Users (user_name, password) VALUES (?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setString(1, user_name);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("error creating new user");
        }

        return false;
    }

    public static boolean check(String user_name){
        String sql = "SELECT * FROM Users WHERE user_name = ?";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setString(1, user_name);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("User not found");
        }

        return false;
    }


    public boolean find(String user_name, String password){
        String sql = "SELECT * FROM Users WHERE user_name = ? AND password = ?";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setString(1, user_name);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.user_id = resultSet.getInt(1);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("User not found");
        }

        return false;
    }

    public static int getUser_id() {
        return user_id;
    }

    // get current user name
}

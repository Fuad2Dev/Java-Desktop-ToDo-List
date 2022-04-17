package Models;

import Controllers.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Todo {

    static ResultSet resultSet;

    public static boolean create(String note){
        String sql = "INSERT INTO note_lists  (user_id, note) VALUES (?, ?)";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setInt(1, User.getUser_id());
            statement.setString(2, note);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("note added successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("error adding note");
        }

        return false;
    }

    public static boolean getUserNotes(){
        String sql = "SELECT * FROM note_lists WHERE user_id = ?";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setInt(1, User.getUser_id());

            resultSet = statement.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println("User not found");
        }
        return false;
    }

    public static boolean deleteNote(int id){
        String sql = "DELETE FROM note_lists WHERE id = ?";

        PreparedStatement statement = null;
        try {
            statement = Connector.connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("note deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("error deleting note");
        }

        return false;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }
}

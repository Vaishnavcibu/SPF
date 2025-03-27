// models/Subject.java
package models;
import database.DatabaseConnection;
import java.sql.*;

public class Subject {
    private int id;
    private String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void addSubject(String name) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO subjects (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
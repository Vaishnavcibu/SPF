// src/database/DatabaseConnection.java
package database;
import java.sql.*;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/study_group";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "rootpassword";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50) NOT NULL UNIQUE, " +
                    "password VARCHAR(255) NOT NULL" +
                    ")";
            stmt.executeUpdate(createUsersTable);

            String createSubjectsTable = "CREATE TABLE IF NOT EXISTS subjects (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL" +
                    ")";
            stmt.executeUpdate(createSubjectsTable);

            String createRequestsTable = "CREATE TABLE IF NOT EXISTS study_requests (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "sender_id INT NOT NULL, " +
                    "receiver_id INT NOT NULL, " +
                    "status VARCHAR(20) NOT NULL, " +
                    "FOREIGN KEY (sender_id) REFERENCES users(id), " +
                    "FOREIGN KEY (receiver_id) REFERENCES users(id)" +
                    ")";
            stmt.executeUpdate(createRequestsTable);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database initialization failed");
        }
    }
}










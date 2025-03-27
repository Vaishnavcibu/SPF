// models/StudyRequest.java
package models;
import database.DatabaseConnection;
import java.sql.*;

public class StudyRequest {
    private int id;
    private int senderId;
    private int receiverId;
    private String status;

    public StudyRequest(int id, int senderId, int receiverId, String status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }

    public static void sendRequest(int senderId, int receiverId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO study_requests (sender_id, receiver_id, status) VALUES (?, ?, 'pending')";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, senderId);
            stmt.setInt(2, receiverId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
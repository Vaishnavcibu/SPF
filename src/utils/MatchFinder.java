package utils;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.User;

public class MatchFinder {
    public static List<User> findMatches(User currentUser) {
        List<User> matches = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE id != ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, currentUser.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                matches.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matches;
    }
}
package ma.ac.esi.nutritrack.repository;

import ma.ac.esi.nutritrack.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Repository responsible for user-related operations in the database.
 */
public class UserRepository {

    private static final String AUTH_QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";

    /**
     * Verifies if a user exists with the given email and password.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return true if the user exists, false otherwise
     */
    public boolean userExists(String email, String password) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(AUTH_QUERY)) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("✅ User authenticated: " + email);
                    return true;
                } else {
                    System.out.println("❌ No user found for: " + email);
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ SQL error during authentication: " + e.getMessage());
        }

        return false;
    }
}

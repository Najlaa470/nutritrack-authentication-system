package ma.ac.esi.nutritrack.repository;

import ma.ac.esi.nutritrack.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Repository responsible for updating ingredient details in the database.
 */
public class EditIngredientRepository {

    private static final String UPDATE_QUERY = 
        "UPDATE ingredients SET name = ?, calories = ? WHERE id = ?";

    /**
     * Updates an existing ingredient's name and calorie value by its ID.
     *
     * @param ingredientId the ID of the ingredient to update
     * @param name         the new name of the ingredient
     * @param calories     the new calorie value
     * @return true if the update was successful, false otherwise
     */
    public boolean editIngredient(int ingredientId, String name, int calories) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, name);
            statement.setInt(2, calories);
            statement.setInt(3, ingredientId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("✏️ Ingredient updated: ID " + ingredientId +
                                   " → " + name + " (" + calories + " kcal)");
                return true;
            } else {
                System.err.println("⚠️ No ingredient updated. Check if ID " + ingredientId + " exists.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ SQL error during ingredient update: " + e.getMessage());
            return false;
        }
    }
}

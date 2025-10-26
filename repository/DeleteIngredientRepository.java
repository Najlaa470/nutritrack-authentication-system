package ma.ac.esi.nutritrack.repository;

import ma.ac.esi.nutritrack.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Repository responsible for deleting an ingredient from the database.
 */
public class DeleteIngredientRepository {

    private static final String DELETE_QUERY = "DELETE FROM ingredients WHERE id = ?";

    /**
     * Deletes an ingredient by its ID.
     *
     * @param ingredientId the ID of the ingredient to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteIngredientFromMeal(int ingredientId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1, ingredientId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("🗑️ Ingredient with ID " + ingredientId + " deleted successfully.");
                return true;
            } else {
                System.err.println("⚠️ No ingredient found with ID " + ingredientId + ". Nothing deleted.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ SQL Error while deleting ingredient: " + e.getMessage());
            return false;
        }
    }
}

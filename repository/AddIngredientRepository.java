package ma.ac.esi.nutritrack.repository;

import ma.ac.esi.nutritrack.model.Ingredient;
import ma.ac.esi.nutritrack.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Repository class responsible for persisting ingredients in the database.
 */
public class AddIngredientRepository {

    private static final String INSERT_QUERY =
        "INSERT INTO ingredients (name, calories, meal_id) VALUES (?, ?, ?)";

    /**
     * Adds a new ingredient to the specified meal.
     *
     * @param mealId     the ID of the meal
     * @param ingredient the ingredient to add
     * @return true if the insertion was successful, false otherwise
     */
    public boolean addIngredientToMeal(int mealId, Ingredient ingredient) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            statement.setString(1, ingredient.getName());
            statement.setInt(2, ingredient.getCalories());
            statement.setInt(3, mealId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("✅ Ingredient '" + ingredient.getName() + "' added to meal ID " + mealId);
                return true;
            } else {
                System.err.println("⚠️ No ingredient inserted. Check input data.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("❌ Database error while adding ingredient: " + e.getMessage());
            return false;
        }
    }
}

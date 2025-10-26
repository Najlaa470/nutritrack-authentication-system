package ma.ac.esi.nutritrack.repository;

import ma.ac.esi.nutritrack.model.Ingredient;
import ma.ac.esi.nutritrack.model.Meal;
import ma.ac.esi.nutritrack.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository responsible for retrieving meals and their ingredients from the database.
 */
public class MealRepository {

    private static final String MEAL_QUERY = "SELECT * FROM meals";
    private static final String INGREDIENT_QUERY = "SELECT * FROM ingredients WHERE meal_id = ?";

    public int totalCalories = 0;
	public Object nbCal;

    /**
     * Retrieves all meals from the database with their associated ingredients.
     *
     * @return a list of Meal objects
     */
    public List<Meal> getAllMeals() {
        List<Meal> meals = new ArrayList<>();
        totalCalories = 0;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement mealStmt = connection.prepareStatement(MEAL_QUERY);
             ResultSet mealRs = mealStmt.executeQuery()) {

            while (mealRs.next()) {
                int mealId = mealRs.getInt("id");
                String mealName = mealRs.getString("name");
                List<Ingredient> ingredients = new ArrayList<>();

                try (PreparedStatement ingStmt = connection.prepareStatement(INGREDIENT_QUERY)) {
                    ingStmt.setInt(1, mealId);
                    try (ResultSet ingRs = ingStmt.executeQuery()) {
                        while (ingRs.next()) {
                            int calories = ingRs.getInt("calories");
                            ingredients.add(new Ingredient(
                                ingRs.getInt("id"),
                                ingRs.getString("name"),
                                calories
                            ));
                            totalCalories += calories;
                        }
                    }
                }

                meals.add(new Meal(mealId, mealName, ingredients));
            }

            System.out.println("✅ " + meals.size() + " meals loaded.");
            System.out.println("🔥 Total calories across all meals: " + totalCalories + " kcal");

        } catch (SQLException e) {
            System.err.println("❌ Error loading meals: " + e.getMessage());
            e.printStackTrace();
        }

        return meals;
    }
}


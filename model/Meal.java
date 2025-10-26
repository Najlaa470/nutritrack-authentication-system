package ma.ac.esi.nutritrack.model;

import java.util.List;

public class Meal {
    private int mealId;
    private String name;
    private List<Ingredient> ingredients;

    public Meal(int mealId, String name, List<Ingredient> ingredients) {
        this.mealId = mealId;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Meal(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // Getters & Setters
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    // ✅ Méthode pour calculer le total des calories du repas
    public int getTotalCalories() {
        int total = 0;
        if (ingredients != null) {
            for (Ingredient ing : ingredients) {
                total += ing.getCalories();
            }
        }
        return total;
    }
}



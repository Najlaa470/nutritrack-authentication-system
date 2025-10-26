package ma.ac.esi.nutritrack.service;

import ma.ac.esi.nutritrack.model.Ingredient;
import ma.ac.esi.nutritrack.repository.AddIngredientRepository;

public class AddIngredientService {
    private final AddIngredientRepository ingredientRepo;

    public AddIngredientService() {
        this.ingredientRepo = new AddIngredientRepository();
    }

    public boolean addIngredientToMeal(int mealId, String name, int calories) {
        Ingredient ingredient = new Ingredient(name, calories);
        return ingredientRepo.addIngredientToMeal(mealId, ingredient);
    }
}
package ma.ac.esi.nutritrack.service;

import ma.ac.esi.nutritrack.repository.DeleteIngredientRepository;

public class DeleteIngredientService {
    private final DeleteIngredientRepository ingredientRepo;

    public DeleteIngredientService() {
        this.ingredientRepo = new DeleteIngredientRepository();
    }

    public boolean deleteIngredientFromMeal(int ingredientId) {
        return ingredientRepo.deleteIngredientFromMeal(ingredientId);
    }
}
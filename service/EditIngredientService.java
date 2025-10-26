package ma.ac.esi.nutritrack.service;

import ma.ac.esi.nutritrack.repository.EditIngredientRepository;

public class EditIngredientService {
    private final EditIngredientRepository ingredientRepo;

    public EditIngredientService() {
        this.ingredientRepo = new EditIngredientRepository();
    }

    public boolean editIngredient(int ingId, String name, int calories) {
    	return this.ingredientRepo.editIngredient(ingId, name, calories);
    	}
}
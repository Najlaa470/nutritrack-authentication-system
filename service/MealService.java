package ma.ac.esi.nutritrack.service;

import ma.ac.esi.nutritrack.repository.MealRepository;

import java.util.List;
import ma.ac.esi.nutritrack.model.Meal;
public class MealService {
	public final MealRepository mealRepository;
	
    public MealService() {
        this.mealRepository = new MealRepository();
    }
    
	public List<Meal> getMeals(){
		return this.mealRepository.getAllMeals();
	}
}


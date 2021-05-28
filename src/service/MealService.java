package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Meal;
import repository.actionsimpl.MealRepositoryImpl;

public class MealService {
    private static final MealRepositoryImpl mealRepository = new MealRepositoryImpl();

    public static List<Meal> retrieveAllMeals() {
        return mealRepository.retrieveAllMeals();
    }

    public static List<Meal> getMealsFromRestaurant(UUID restaurantID) {
        return mealRepository.getMealsFromRestaurant(restaurantID);
    }

    public static Optional<Meal> getMealByID(UUID id) {
        return mealRepository.getMealByID(id);
    }

    public static boolean addMeal(Meal meal) {
        return mealRepository.addMeal(meal);
    }

    public static boolean deleteMealByID(UUID mealID) {
        return mealRepository.deleteMeal(mealID);
    }
}

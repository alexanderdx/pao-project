package repository.actions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Meal;

public interface MealRepository {

    List<Meal> retrieveAllMeals();

    List<Meal> getMealsFromRestaurant(UUID restaurantID);

    Optional<Meal> getMealByID(UUID id);
}

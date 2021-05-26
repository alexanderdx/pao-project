package repository.actions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Restaurant;

public interface RestaurantRepository {

    List<Restaurant> retrieveAllRestaurants();

    boolean addRestaurant(Restaurant restaurant);

    Optional<Restaurant> getRestaurantByID(UUID id);

    Optional<Restaurant> getRestaurantByName(String name);
}

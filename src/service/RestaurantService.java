package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Restaurant;
import repository.actionsimpl.RestaurantRepositoryImpl;

public class RestaurantService {
    private static final RestaurantRepositoryImpl restaurantRepository = new RestaurantRepositoryImpl();

    public static boolean addRestaurant(Restaurant restaurant) {
        return restaurantRepository.addRestaurant(restaurant);
    }

    public static boolean deleteRestaurantByID(UUID uuid) {
        return restaurantRepository.deleteRestaurant(uuid);
    }

    public static List<Restaurant> retrieveAllRestaurants() {
        return restaurantRepository.retrieveAllRestaurants();
    }

    public static Optional<Restaurant> getRestaurantByID(UUID id) {
        return restaurantRepository.getRestaurantByID(id);
    }

    public static Optional<Restaurant> getRestaurantByName(String name) {
        return restaurantRepository.getRestaurantByName(name);
    }
}

package repository.actionsimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Menu;
import model.Restaurant;
import repository.actions.RestaurantRepository;
import utils.DbConnection;
import utils.Queries;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();
    private final MealRepositoryImpl mealRepository = new MealRepositoryImpl();

    @Override
    public List<Restaurant> retrieveAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_RESTAURANTS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                UUID restaurantID = UUID.fromString(resultSet.getString(1));
                Menu menu = new Menu(mealRepository.getMealsFromRestaurant(restaurantID));
                restaurants.add(Restaurant.fromResultSet(resultSet, menu));
            }

            return restaurants;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addRestaurant(Restaurant restaurant) {
         try {
             PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.ADD_RESTAURANT);
             pstm.setString(1, restaurant.getUUID().toString());
             pstm.setString(2, restaurant.getLocation().getAddress());
             pstm.setString(3, restaurant.getName());
             pstm.setDouble(4, restaurant.getRating());

             return pstm.executeUpdate() == 1;

         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }

         return false;
    }

    @Override
    public Optional<Restaurant> getRestaurantByID(UUID id) {
        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.GET_RESTAURANT_BY_ID);
            pstm.setString(1, id.toString());

            ResultSet resultSet = pstm.executeQuery();

            Menu menu = new Menu(mealRepository.getMealsFromRestaurant(id));

            if (resultSet.next()) {
                return Optional.of(Restaurant.fromResultSet(resultSet, menu));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> getRestaurantByName(String name) {
        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.GET_RESTAURANT_BY_NAME);
            pstm.setString(1, name);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                UUID restaurantID = UUID.fromString(resultSet.getString(1));
                Menu menu = new Menu(mealRepository.getMealsFromRestaurant(restaurantID));
                return Optional.of(Restaurant.fromResultSet(resultSet, menu));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteRestaurant(UUID uuid) {
        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.DELETE_RESTAURANT);
            pstm.setString(1, uuid.toString());

            return pstm.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

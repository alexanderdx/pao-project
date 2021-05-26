package repository.actionsimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Location;
import model.Menu;
import model.Restaurant;
import repository.actions.RestaurantRepository;
import utils.DbConnection;
import utils.Queries;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public List<Restaurant> retrieveAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_RESTAURANTS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                restaurants.add(new Restaurant(resultSet.getString(3), new Menu(), new Location(resultSet.getString(2)), 4.7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return restaurants;
    }

    @Override
    public boolean addRestaurant(Restaurant restaurant) {
        return true;
    }

    @Override
    public Optional<Restaurant> getRestaurantByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> getRestaurantByName(String name) {
        return Optional.empty();
    }
}

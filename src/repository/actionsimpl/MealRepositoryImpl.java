package repository.actionsimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Meal;
import repository.actions.MealRepository;
import utils.DbConnection;
import utils.Queries;

public class MealRepositoryImpl implements MealRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public List<Meal> retrieveAllMeals() {
        List<Meal> meals = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_MEALS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                meals.add(Meal.fromResultSet(resultSet));
            }

            return meals;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Meal> getMealsFromRestaurant(UUID restaurantID) {
        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.GET_MEALS_FROM_RESTAURANT);
            pstm.setString(1, restaurantID.toString());
            ResultSet resultSet = pstm.executeQuery();
            List<Meal> meals = new ArrayList<>();

            while (resultSet.next())
            {
                meals.add(Meal.fromResultSet(resultSet));
            }

            return meals;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Meal> getMealByID(UUID id) {
        return Optional.empty();
    }
}

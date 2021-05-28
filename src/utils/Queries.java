package utils;

public class Queries {
    public static final String RETRIEVE_ALL_RESTAURANTS = "SELECT id, name, location, rating FROM restaurant";

    public static final String ADD_RESTAURANT = "INSERT INTO restaurant(id, location, name, rating) "
            + "VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE location = VALUES(location), name = VALUES(name), rating = VALUES(rating)";

    public static final String GET_RESTAURANT_BY_ID = "SELECT id, location, name, rating "
            + "FROM restaurant WHERE id = ?";

    public static final String GET_RESTAURANT_BY_NAME = "SELECT id, location, name, rating "
            + "FROM restaurant WHERE lower(name) = lower(?)";

    public static final String RETRIEVE_ALL_ORDERS = "SELECT * FROM orders";

    public static final String RETRIEVE_ALL_MEALS = "SELECT id, name, ingredients, price, weight, category FROM meal";

    public static final String GET_MEALS_FROM_RESTAURANT = "SELECT id, name, ingredients, price, weight, category "
            + "FROM restaurant_meal rm "
            + "INNER JOIN meal m ON rm.mealID = m.id "
            + "WHERE rm.restaurantID = ?";

    public static final String ADD_CUSTOMER = "INSERT INTO customer(id, firstName, lastName, location, phone) "
            + "VALUES (?, ?, ?, ?, ?) ";

    public static final String RETRIEVE_ALL_CUSTOMERS = "SELECT id, firstName, lastName, location, phone FROM customer";

    public static final String RETRIEVE_ALL_DRIVERS = "SELECT id, firstName, lastName, location, phone, licensePlate, carModel, isAvailable FROM driver";

    public static final String ADD_MEAL = "INSERT INTO meal(id, ingredients, weight, category, name, price) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    public static final String DELETE_MEAL = "DELETE FROM meal WHERE id = ?";
}

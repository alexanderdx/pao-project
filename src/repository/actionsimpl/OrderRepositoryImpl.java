package repository.actionsimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Order;
import repository.actions.OrderRepository;
import utils.DbConnection;
import utils.Queries;

public class OrderRepositoryImpl implements OrderRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public List<Order> retrieveAllOrders() {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_ORDERS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                //orders.add(new Order(resultSet.getString(3), new Menu(), new Location(resultSet.getString(2)), 4.7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }

    @Override
    public Optional<Order> getOrdersFromCustomer(UUID customerid) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> getOrderByID(UUID id) {
        return Optional.empty();
    }
}

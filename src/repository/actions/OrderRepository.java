package repository.actions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Order;

public interface OrderRepository {

    List<Order> retrieveAllOrders();

    Optional<Order> getOrdersFromCustomer(UUID customerid);

    Optional<Order> getOrderByID(UUID id);
}

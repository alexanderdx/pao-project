package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Order;
import repository.actionsimpl.OrderRepositoryImpl;

public class OrderService {
    private static final OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();

    public static List<Order> retrieveAllOrders() {
        return orderRepository.retrieveAllOrders();
    }

    public static Optional<Order> getOrdersFromCustomer(UUID customerid) {
        return orderRepository.getOrdersFromCustomer(customerid);
    }

    public static Optional<Order> getOrderByID(UUID id) {
        return orderRepository.getOrderByID(id);
    }
}

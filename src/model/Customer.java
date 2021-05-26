package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends User {
    private final List<Order> orders;
    private final ShoppingCart cart;

    public Customer() {
        this.orders = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public Customer(String firstName, String lastName, Location location, String phone) {
        super(firstName, lastName, location, phone);
        this.orders = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public Customer(UUID id, String firstName, String lastName, Location location, String phone) {
        super(id, firstName, lastName, location, phone);
        this.orders = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public Order placeOrder(List<Driver> drivers) {
        Driver assignedDriver = drivers
                .stream()
                .filter(Driver::getAvailability)
                .findAny()
                .orElse(null);

        if (assignedDriver != null) {
            return new Order(this, assignedDriver, this.cart, cart.getRestaurant());

        } else {
            System.out.println("No drivers are available to deliver your order now. Please try again later!");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", address='" + super.getLocation().getAddress() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                "orders=" + orders +
                ", cart=" + cart +
                '}';
    }
}

package model;

import java.util.List;

public class Order extends Entity {
    private User customer;
    private Driver assignedDriver;
    private List<Item> items;
    private final double totalPrice;
    private Restaurant restaurant;

    public Order(User customer, Driver assignedDriver, ShoppingCart cart, Restaurant restaurant) {
        super();
        this.customer = customer;
        this.assignedDriver = assignedDriver;
        this.items = cart.getItems();
        this.totalPrice = cart.getTotalPrice();
        this.restaurant = restaurant;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public List<Item> getitems() {
        return items;
    }

    public void setitems(List<Item> items) {
        this.items = items;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + super.getUUID() +
                ", creationDate=" + super.getCreationDate() +
                ", customer=" + customer +
                ", assignedDriver=" + assignedDriver +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", restaurant=" + restaurant +
                '}';
    }
}

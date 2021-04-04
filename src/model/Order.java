package model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID orderID;
    private Date creationDate;
    private User customer;
    private Driver assignedDriver;
    private List<Item> items;
    private final int totalPrice;
    private Restaurant restaurant;

    public Order(User customer, Driver assignedDriver, ShoppingCart cart, Restaurant restaurant) {
        this.orderID = UUID.randomUUID();
        this.creationDate = new Date();
        this.customer = customer;
        this.assignedDriver = assignedDriver;
        this.items = cart.getItems();
        this.totalPrice = cart.getTotalPrice();
        this.restaurant = restaurant;
    }

    public UUID getOrderID() {
        return orderID;
    }

    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", creationDate=" + creationDate +
                ", customer=" + customer +
                ", assignedDriver=" + assignedDriver +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", restaurant=" + restaurant +
                '}';
    }
}

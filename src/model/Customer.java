package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Order> orders;
    private ShoppingCart cart;

    public Customer() {
        this.orders = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public Customer(String firstName, String lastName, String address, String phone) {
        super(firstName, lastName, address, phone);
        this.orders = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                "orders=" + orders +
                ", cart=" + cart +
                '}';
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items;
    private double totalPrice;
    private Restaurant restaurant; // you can only order items from a single restaurant

    public ShoppingCart() {
        items = new ArrayList<>();
        totalPrice = 0;
    }

    public void addItem(Item item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public void removeItem(Item item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    public void emptyCart() {
        items.clear();
        totalPrice = 0;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

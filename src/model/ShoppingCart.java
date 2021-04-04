package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items;
    private int totalPrice;

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

    public List<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

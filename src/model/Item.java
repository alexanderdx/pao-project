package model;

import java.util.UUID;

public abstract class Item extends Entity {
    private String name;
    private double price;
    private Restaurant restaurant;

    public Item(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Item(UUID id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

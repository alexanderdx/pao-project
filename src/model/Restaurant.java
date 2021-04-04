package model;

import java.util.List;

public class Restaurant {
    private String name;
    private List<Meal> menu;
    private String address;
    private double rating;

    public Restaurant(String name, List<Meal> menu, String address, int rating) {
        this.name = name;
        this.menu = menu;
        this.address = address;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }
}

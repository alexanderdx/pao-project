package model;

public class Restaurant extends Entity {
    private String name;
    private Menu menu;
    private Location location;
    private double rating;

    public Restaurant(String name, Menu menu, Location location, double rating) {
        super();
        this.name = name;
        this.menu = menu;
        this.location = location;
        this.rating = rating;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Location getLocation() {
        return location;
    }

    public void setAddress(Location location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addToMenu(Meal meal) { menu.addToMenu(meal); }

    public void removeFromMenu(Meal meal) { menu.removeFromMenu(meal); }

    @Override
    public String toString() {
        return "------------ Restaurant " + name + " ------------"
                + "\nAdresa: " + location.getAddress()
                + "\nRating: " + rating
                + "\nMeniu: " + menu.toString();
    }
}

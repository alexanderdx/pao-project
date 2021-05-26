package model;

import java.util.ArrayList;
import java.util.List;

public class Meal extends Item {
    private List<String> ingredients;
    private int weight;
    private String category;

    public Meal() {
        super("Null", 0, new Restaurant());
        this.ingredients = new ArrayList<String>();
        this.ingredients.add("Empty meal");
        this.weight = 0;
        this.category = "None";
    }

    public Meal(String name, List<String> ingredients, double price, int weight, String category, Restaurant restaurant) {
        super(name, price, restaurant);
        this.ingredients = ingredients;
        this.weight = weight;
        this.category = category;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.getName() + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + super.getPrice() +
                ", weight=" + weight +
                ", category='" + category + '\'' +
                '}';
    }
}

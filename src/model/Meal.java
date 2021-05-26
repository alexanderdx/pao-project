package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Meal extends Item {
    private List<String> ingredients;
    private int weight;
    private String category;

    public Meal() {
        super("Null", 0);
        this.ingredients = new ArrayList<String>();
        this.ingredients.add("Empty meal");
        this.weight = 0;
        this.category = "None";
    }

    public Meal(String name, List<String> ingredients, double price, int weight, String category) {
        super(name, price);
        this.ingredients = ingredients;
        this.weight = weight;
        this.category = category;
    }

    public Meal(UUID id, String name, List<String> ingredients, double price, int weight, String category) {
        super(id, name, price);
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
        return super.getName() +
                ", ingredients=" + ingredients +
                ", price=" + super.getPrice() +
                ", weight=" + weight +
                ", category='" + category + '\'' +
                ", uuid= " + super.getUUID().toString() +
                '}';
    }

    public static Meal fromResultSet(ResultSet resultSet) throws SQLException {
        return new Meal(UUID.fromString(resultSet.getString(1)), resultSet.getString(2), Arrays.asList(resultSet.getString(3).split(",")), resultSet.getDouble(4),
                resultSet.getInt(5), resultSet.getString(6));
    }
}

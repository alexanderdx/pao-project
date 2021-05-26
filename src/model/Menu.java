package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private final Map<String, List<Meal>> menu; // Hashmap de tipul (Categorie, [Lista de preparate])

    public Menu() {
        this.menu = new HashMap<String, List<Meal>>();
    }

    public void addToMenu(Meal meal) {
        if (!menu.containsKey(meal.getCategory())) {
            menu.put(meal.getCategory(), new ArrayList<Meal>(Arrays.asList(meal)));
        } else {
            menu.get(meal.getCategory()).add(meal);
        }
    }

    public void removeFromMenu(Meal meal) {
        menu.get(meal.getCategory()).remove(meal);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (String categ : menu.keySet()) {
            sb.append(categ);
            sb.append(": ");
            menu.get(categ)
                    .forEach(meal -> sb.append(meal.toString()).append("\n"));
        }

        return sb.toString();
    }
}

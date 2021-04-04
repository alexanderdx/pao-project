package service;

import model.Meal;
import model.Restaurant;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Scanner in) {
        System.out.println("Enter restaurant data:");
        System.out.println("Name:");
        String name = in.nextLine();

        // To DO - read menu
        List<Meal> menu = new ArrayList<>();

        System.out.println("Address:");
        String address = in.nextLine();

        System.out.println("Rating:");
        int rating = Integer.parseInt(in.nextLine());

        Restaurant restaurant = new Restaurant(name, menu, address, rating);
        restaurants.add(restaurant);
    }

    public void printRestaurants() {
        System.out.println(restaurants);
    }
}

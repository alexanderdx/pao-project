package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Customer;
import model.Driver;
import model.Location;
import model.Meal;
import model.Menu;
import model.Restaurant;

public class MenuInterfaceService {
    private static final Scanner in = new Scanner(System.in);

    private static final AuditService logger = new AuditService();;

    public static void stop() {
        logger.close();
    }

    public static void addRestaurant() {
        System.out.println("Enter restaurant data:");
        System.out.println("Name:");
        String name = in.nextLine();

        if (name.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        System.out.println("Address:");
        String address = in.nextLine();

        if (address.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        Location location = new Location(address);

        System.out.println("Rating:");
        double rating = parseDoubleWithException();

        Menu menu = new Menu();

        Restaurant restaurant = new Restaurant(name, menu, location, rating);

        System.out.println("Introduceti preparatele din meniul restaurantului (enter fara a scrie nimic pt a opri):");

        while (true) {
            String nume_preparat;
            List<String> ingrediente;
            String categorie;
            double pret;
            int weight;

            System.out.println("Nume preparat: ");
            String input = in.nextLine();
            if (input.isBlank())
                break;

            nume_preparat = input;

            System.out.println("Ingrediente preparat (separate prin virgula): ");
            input = in.nextLine();
            if (input.isBlank())
                break;

            ingrediente = Arrays.asList(input.split(","));

            System.out.println("Categoria preparatului: ");
            input = in.nextLine();
            if (input.isBlank())
                break;

            categorie = input;

            System.out.println("Pretul preparatului: ");
            pret = parseDoubleWithException();
            if (pret == -1)
                break;

            System.out.println("Gramajul preparatului: ");
            weight = parseIntWithException();
            if (weight == -1)
                break;

            restaurant.addToMenu(new Meal(nume_preparat, ingrediente, pret, weight, categorie));
        }

        RestaurantService.addRestaurant(restaurant);
        logger.log("A restaurant was added");
    }

    public static void deleteRestaurant() {
        String uuid;
        System.out.println("Introduceti ID-ul restaurantului: ");

        uuid = in.nextLine();
        if (uuid.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        RestaurantService.deleteRestaurantByID(UUID.fromString(uuid));
    }

    public static void addMeal() {
        String nume_preparat;
        List<String> ingrediente;
        String categorie;
        double pret;
        int weight;

        System.out.println("Nume preparat: ");
        String input = in.nextLine();
        if (input.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        nume_preparat = input;

        System.out.println("Ingrediente preparat (separate prin virgula): ");
        input = in.nextLine();
        if (input.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        ingrediente = Arrays.asList(input.split(","));

        System.out.println("Categoria preparatului: ");
        input = in.nextLine();
        if (input.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        categorie = input;

        System.out.println("Pretul preparatului: ");
        pret = parseDoubleWithException();
        if (pret == -1) {
            System.out.println("Operation aborted!");
            return;
        }

        System.out.println("Gramajul preparatului: ");
        weight = parseIntWithException();
        if (weight == -1) {
            System.out.println("Operation aborted!");
            return;
        }

        MealService.addMeal(new Meal(nume_preparat, ingrediente, pret, weight, categorie));
    }

    public static void deleteMeal() {
        String uuid;
        System.out.println("Introduceti ID-ul preparatului: ");

        uuid = in.nextLine();
        if (uuid.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        MealService.deleteMealByID(UUID.fromString(uuid));
    }

    public static void registerCustomer() {
        System.out.println("Enter customer data:");
        System.out.println("First name:");
        String firstName = in.nextLine();

        System.out.println("Last name:");
        String lastName = in.nextLine();

        System.out.println("Address:");
        Location location = new Location(in.nextLine());

        System.out.println("Phone number:");
        String phone = in.nextLine();

        Customer customer = new Customer(firstName, lastName, location, phone);
        UserService.addCustomer(customer);
        logger.log("A customer was added");
    }

    public static void deleteCustomer() {
        String uuid;
        System.out.println("Introduceti ID-ul clientului: ");

        uuid = in.nextLine();
        if (uuid.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        UserService.deleteCustomerByID(UUID.fromString(uuid));
    }

    public static void registerDriver() {
        System.out.println("Enter driver data:");
        System.out.println("First name:");
        String firstName = in.nextLine();

        System.out.println("Last name:");
        String lastName = in.nextLine();

        System.out.println("Address:");
        Location location = new Location(in.nextLine());

        System.out.println("Phone number:");
        String phone = in.nextLine();

        System.out.println("License plate:");
        String licensePlate = in.nextLine();

        System.out.println("Car model:");
        String carModel = in.nextLine();

        Driver driver = new Driver(firstName, lastName, location, phone, licensePlate, carModel);
        UserService.addDriver(driver);
        logger.log("A driver was added");
    }

    public static void deleteDriver() {
        String uuid;
        System.out.println("Introduceti ID-ul soferului: ");

        uuid = in.nextLine();
        if (uuid.isBlank()) {
            System.out.println("Operation aborted!");
            return;
        }

        UserService.deleteDriverByID(UUID.fromString(uuid));
    }

    public static void generateCSVReport() {
        logger.log("CSV report was generated");
        final String path = "reports/";

        StringBuilder report = new StringBuilder();
        List<Restaurant> restaurants = RestaurantService.retrieveAllRestaurants();

        report.append("uuid,nume,adresa,rating\n");
        for (Restaurant r : restaurants) {
            report.append(r.getUUID().toString()).append(", ");
            report.append(r.getName()).append(", ");
            report.append(r.getLocation().getAddress()).append(", ");
            report.append(String.valueOf(r.getRating())).append(", ");
            report.append("\n");
        }
        try {
            if (!Files.exists(Paths.get(path + "restaurants.csv"))) {
                Files.createFile(Paths.get(path + "restaurants.csv"));
            }
            Files.write(Paths.get(path + "restaurants.csv"), report.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        report = new StringBuilder();
        List<Meal> meals = MealService.retrieveAllMeals();

        report.append("uuid, name, price, weight, category, ingredients\n");
        for (Meal m : meals) {
            report.append(m.getUUID().toString()).append(", ");
            report.append(m.getName()).append(", ");
            report.append(String.valueOf(m.getPrice())).append(", ");
            report.append(String.valueOf(m.getWeight())).append(", ");
            report.append(m.getCategory()).append(", ");
            report.append(String.join(", ", m.getIngredients())).append(", ");
            report.append("\n");
        }
        try {
            if (!Files.exists(Paths.get(path + "meals.csv"))) {
                Files.createFile(Paths.get(path + "meals.csv"));
            }
            Files.write(Paths.get(path + "meals.csv"), report.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        report = new StringBuilder();
        List<Customer> customers = UserService.getAllCustomers();

        report.append("id, firstName, lastName, location, phone\n");
        for (Customer c : customers) {
            report.append(c.getUUID().toString()).append(", ");
            report.append(c.getFirstName()).append(", ");
            report.append(c.getLastName()).append(", ");
            report.append(c.getLocation().getAddress()).append(", ");
            report.append(c.getPhone());
            report.append("\n");
        }
        try {
            if (!Files.exists(Paths.get(path + "customers.csv"))) {
                Files.createFile(Paths.get(path + "customers.csv"));
            }
            Files.write(Paths.get(path + "customers.csv"), report.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        report = new StringBuilder();
        List<Driver> drivers = UserService.getAllDrivers();

        report.append("id, firstName, lastName, location, phone, licensePlate, carModel, isAvailable\n");
        for (Driver d : drivers) {
            report.append(d.getUUID().toString()).append(", ");
            report.append(d.getFirstName()).append(", ");
            report.append(d.getLastName()).append(", ");
            report.append(d.getLocation().getAddress()).append(", ");
            report.append(d.getPhone()).append(", ");
            report.append(d.getLicensePlate()).append(", ");
            report.append(d.getCarModel()).append(", ");
            report.append(d.getAvailability());
            report.append("\n");
        }
        try {
            if (!Files.exists(Paths.get(path + "drivers.csv"))) {
                Files.createFile(Paths.get(path + "drivers.csv"));
            }
            Files.write(Paths.get(path + "drivers.csv"), report.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printUsers() {
        logger.log("All users were printed");

        List<Customer> customers = UserService.getAllCustomers();
        if (customers != null) {
            customers.forEach(System.out::println);
        }
        else {
            System.out.println("There are no customers registered!");
        }

        List<Driver> drivers = UserService.getAllDrivers();
        if (drivers != null) {
            drivers.forEach(System.out::println);
        }
        else {
            System.out.println("There are no drivers registered!");
        }
    }

    public static void printRestaurants() {
        logger.log("All restaurants were printed");

        List<Restaurant> restaurants = RestaurantService.retrieveAllRestaurants();
        restaurants.forEach(System.out::println);
    }

    public static void printAllMeals() {
        logger.log("All meals were printed");

        List<Meal> meals = MealService.retrieveAllMeals();
        meals.forEach(System.out::println);
    }

    private static int parseIntWithException() {
        do {
            try {
                String str = MenuInterfaceService.in.nextLine();
                if (str.isBlank())
                    return -1;

                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Introduceti un numar valid! Incercati din nou...");
            }

        } while (true);
    }

    private static double parseDoubleWithException() {
        do {
            try {
                String str = MenuInterfaceService.in.nextLine();
                if (str.isBlank())
                    return -1;

                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Introduceti un numar valid! Incercati din nou...");
            }

        } while (true);
    }
}

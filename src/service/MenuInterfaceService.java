package service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

        System.out.println("Address:");
        Location location = new Location(in.nextLine());

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

            restaurant.addToMenu(new Meal(nume_preparat, ingrediente, pret, weight, categorie, restaurant));
        }

        RestaurantService.addRestaurant(restaurant);
        logger.log("A restaurant was added");
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

    public static void printUsers() {
    }

    public static void printRestaurants() {
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

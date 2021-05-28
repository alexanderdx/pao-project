package usermenu;

import java.util.Scanner;
import service.MenuInterfaceService;

public class Menu {

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        final String menu = """
                                
                Choose your desired action:
                0) Quit
                1) Add a customer
                2) Add a driver
                3) Delete a customer
                4) Delete a driver
                5) Show all users
                6) Add a restaurant
                7) Delete a restaurant
                8) Show restaurants
                9) Add a new meal
                10) Delete a meal
                11) Show all meals
                12) Generate CSV report
                """;

        boolean stop = false;

        while (!stop) {
            try {
                System.out.println(menu);
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 0 -> stop = true;
                    case 1 -> MenuInterfaceService.registerCustomer();
                    case 2 -> MenuInterfaceService.registerDriver();
                    case 3 -> MenuInterfaceService.deleteCustomer();
                    case 4 -> MenuInterfaceService.deleteDriver();
                    case 5 -> MenuInterfaceService.printUsers();
                    case 6 -> MenuInterfaceService.addRestaurant();
                    case 7 -> MenuInterfaceService.deleteRestaurant();
                    case 8 -> MenuInterfaceService.printRestaurants();
                    case 9 -> MenuInterfaceService.addMeal();
                    case 10 -> MenuInterfaceService.deleteMeal();
                    case 11 -> MenuInterfaceService.printAllMeals();
                    case 12 -> MenuInterfaceService.generateCSVReport();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        MenuInterfaceService.stop();
    }
}


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
                3) Show all users
                4) Add a restaurant
                5) Show restaurants
                6) Add a new meal
                7) Delete a meal
                8) Show all meals
                9) Generate CSV report
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
                    case 3 -> MenuInterfaceService.printUsers();
                    case 4 -> MenuInterfaceService.addRestaurant();
                    case 5 -> MenuInterfaceService.printRestaurants();
                    case 6 -> MenuInterfaceService.addMeal();
                    case 7 -> MenuInterfaceService.deleteMeal();
                    case 8 -> MenuInterfaceService.printAllMeals();
                    case 9 -> MenuInterfaceService.generateCSVReport();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        MenuInterfaceService.stop();
    }
}


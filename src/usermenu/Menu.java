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
                3) Add a restaurant
                4) Show all users
                5) Show restaurants
                6) Add item to cart for customer no. x (where x = index in print array)
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
                    case 3 -> MenuInterfaceService.addRestaurant();
                    case 4 -> MenuInterfaceService.printUsers();
                    case 5 -> MenuInterfaceService.printRestaurants();
                    case 6 -> {
                        System.out.println("Choose customer's index:");
                        int index = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter item's name:");
                        String itemName = scanner.nextLine();

                        System.out.println("Enter item's price:");
                        int price = Integer.parseInt(scanner.nextLine());

//                    Item item = new Item(itemName, price, ItemType.MEAL);
//                    userService.addItemToCart(item, index);
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        MenuInterfaceService.stop();
    }
}


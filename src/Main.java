import model.Item;
import model.ItemType;
import model.User;
import service.RestaurantService;
import service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        RestaurantService restaurantService = new RestaurantService();

        Scanner scanner = new Scanner(System.in);

        final String menu = """
                Choose your desired action:
                1) Add a customer
                2) Add a driver
                3) Add a restaurant
                4) Show all users
                5) Show restaurants
                6) Add item to cart for customer no. x (where x = index in print array)
                """;

        boolean stop = false;

        while(!stop) {
            System.out.println(menu);
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 0 -> stop = true;
                case 1 -> userService.registerCustomer(scanner);
                case 2 -> userService.registerDriver(scanner);
                case 3 -> restaurantService.addRestaurant(scanner);
                case 4 -> userService.printUsers();
                case 5 -> restaurantService.printRestaurants();
                case 6 -> {
                    System.out.println("Choose customer's index:");
                    int index = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter item's name:");
                    String itemName = scanner.nextLine();

                    System.out.println("Enter item's price:");
                    int price = Integer.parseInt(scanner.nextLine());

                    Item item = new Item(itemName, price, ItemType.MEAL);
                    userService.addItemToCart(item, index);
                    }
                }
            }
        }
}

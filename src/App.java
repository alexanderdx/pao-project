import java.util.List;
import model.Restaurant;
import service.RestaurantService;
import usermenu.Menu;
public class App {

    public static void main(String[] args) {
        RestaurantService service = new RestaurantService();
        List<Restaurant> r = service.retrieveAllRestaurants();
        System.out.println(r);
        Menu.start();
    }
}

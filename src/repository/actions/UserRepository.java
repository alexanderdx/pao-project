package repository.actions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import model.User;

public interface UserRepository {
    boolean addCustomer(Customer customer);

    boolean addDriver(Driver driver);

    List<User> getAllUsers();

    Optional<User> getUserByID(UUID uuid);

    Optional<User> getUserByName(String firstName, String lastName);
}

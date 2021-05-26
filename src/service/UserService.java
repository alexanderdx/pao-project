package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import model.User;
import repository.actionsimpl.UserRepositoryImpl;

public class UserService {
    private static final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public static boolean addCustomer(Customer customer) {
        return userRepository.addCustomer(customer);
    }

    public static boolean addDriver(Driver driver) {
        return userRepository.addDriver(driver);
    }

    public static List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public static Optional<User> getUserByID(UUID uuid) {
        return userRepository.getUserByID(uuid);
    }

    public static Optional<User> getUserByName(String firstName, String lastName) {
        return userRepository.getUserByName(firstName, lastName);
    }
}

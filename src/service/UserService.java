package service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import repository.actionsimpl.UserRepositoryImpl;

public class UserService {
    private static final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public static boolean addCustomer(Customer customer) {
        return userRepository.addCustomer(customer);
    }

    public static boolean addDriver(Driver driver) {
        return userRepository.addDriver(driver);
    }

    public static List<Customer> getAllCustomers() {
        return userRepository.getAllCustomers();
    }

    public static List<Driver> getAllDrivers() {
        return userRepository.getAllDrivers();
    }

    public static Optional<Customer> getCustomerByID(UUID uuid) {
        return Optional.empty();
    }

    public static Optional<Driver> getDriverByID(UUID uuid) {
        return Optional.empty();
    }

    public static Optional<Customer> getCustomerByName(String firstName, String lastName) {
        return Optional.empty();
    }

    public static Optional<Driver> getDriverByName(String firstName, String lastName) {
        return Optional.empty();
    }
}

package service;

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

}

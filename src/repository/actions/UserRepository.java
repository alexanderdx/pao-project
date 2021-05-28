package repository.actions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;

public interface UserRepository {
    boolean addCustomer(Customer customer);

    boolean addDriver(Driver driver);

    boolean deleteCustomer(UUID uuid);

    boolean deleteDriver(UUID uuid);

    List<Customer> getAllCustomers();

    List<Driver> getAllDrivers();

    Optional<Customer> getCustomerByID(UUID uuid);

    Optional<Driver> getDriverByID(UUID uuid);

    Optional<Customer> getCustomerByName(String firstName, String lastName);

    Optional<Driver> getDriverByName(String firstName, String lastName);
}

package repository.actionsimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import repository.actions.UserRepository;
import utils.DbConnection;

public class UserRepositoryImpl implements UserRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean addDriver(Driver driver) {
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return null;
    }

    @Override
    public Optional<Customer> getCustomerByID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Driver> getDriverByID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getCustomerByName(String firstName, String lastName) {
        return Optional.empty();
    }

    @Override
    public Optional<Driver> getDriverByName(String firstName, String lastName) {
        return Optional.empty();
    }
}

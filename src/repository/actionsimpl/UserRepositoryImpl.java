package repository.actionsimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import model.User;
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
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserByID(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByName(String firstName, String lastName) {
        return Optional.empty();
    }
}

package repository.actionsimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import model.Customer;
import model.Driver;
import repository.actions.UserRepository;
import utils.DbConnection;
import utils.Queries;

public class UserRepositoryImpl implements UserRepository {

    private final DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.ADD_CUSTOMER);
            pstm.setString(1, customer.getUUID().toString());
            pstm.setString(2, customer.getFirstName());
            pstm.setString(3, customer.getLastName());
            pstm.setString(4, customer.getLocation().getAddress());
            pstm.setString(5, customer.getPhone());

            return pstm.executeUpdate() == 1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean addDriver(Driver driver) {
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_CUSTOMERS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                customers.add(Customer.fromResultSet(resultSet));
            }

            return customers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();

        try {
            PreparedStatement pstm = dbConnection.getDBConnection().prepareStatement(Queries.RETRIEVE_ALL_DRIVERS);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                drivers.add(Driver.fromResultSet(resultSet));
            }

            return drivers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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

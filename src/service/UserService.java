package service;

import model.Customer;
import model.Driver;
import model.Item;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static List<User> users = new ArrayList<>();

    public void registerCustomer(Scanner in) {
        System.out.println("Enter customer data:");
        System.out.println("First name:");
        String firstName = in.nextLine();

        System.out.println("Last name:");
        String lastName = in.nextLine();

        System.out.println("Address:");
        String address = in.nextLine();

        System.out.println("Phone number:");
        String phone = in.nextLine();

        Customer customer = new Customer(firstName, lastName, address, phone);
        users.add(customer);
    }

    public void registerDriver(Scanner in) {
        System.out.println("Enter driver data:");
        System.out.println("First name:");
        String firstName = in.nextLine();

        System.out.println("Last name:");
        String lastName = in.nextLine();

        System.out.println("Address:");
        String address = in.nextLine();

        System.out.println("Phone number:");
        String phone = in.nextLine();

        System.out.println("License plate:");
        String licensePlate = in.nextLine();

        System.out.println("Car model:");
        String carModel = in.nextLine();

        Driver driver = new Driver(firstName, lastName, address, phone, licensePlate, carModel);
        users.add(driver);
    }

    public void addItemToCart(Item item, int index) {

        ((Customer)users.get(index)).getCart().addItem(item);
    }

    public void printUsers() {
        System.out.println(users);
    }

    public User getUser(int index) {
        return users.get(index);
    }
}

package model;

public abstract class User extends Entity {
    private String firstName;
    private String lastName;
    private Location location;
    private String phone;

    public User() { super(); }
    public User(String firstName, String lastName, Location location, String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + location.getAddress() + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

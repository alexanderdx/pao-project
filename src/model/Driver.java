package model;

import java.util.UUID;

public class Driver extends User {
    private String licensePlate;
    private String carModel;
    private boolean isAvailable;

    public Driver(String firstName, String lastName, Location location, String phone, String licensePlate, String carModel) {
        super(firstName, lastName, location, phone);
        this.licensePlate = licensePlate;
        this.carModel = carModel;
        this.isAvailable = true;
    }

    public Driver(UUID id, String firstName, String lastName, Location location, String phone, String licensePlate, String carModel) {
        super(id, firstName, lastName, location, phone);
        this.licensePlate = licensePlate;
        this.carModel = carModel;
        this.isAvailable = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setAvailability(boolean var) { this.isAvailable = var; }

    public boolean getAvailability() { return this.isAvailable; }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", address='" + super.getLocation().getAddress() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                "licensePlate='" + licensePlate + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}

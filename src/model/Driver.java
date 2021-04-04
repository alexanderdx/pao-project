package model;

public class Driver extends User {
    private String licensePlate;
    private String carModel;

    public Driver(String firstName, String lastName, String address, String phone, String licensePlate, String carModel) {
        super(firstName, lastName, address, phone);
        this.licensePlate = licensePlate;
        this.carModel = carModel;
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

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                "licensePlate='" + licensePlate + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}

package model;

import java.util.Map;
import utils.OpenStreetMapUtil;

public class Location {
    private final String address;
    private double longitude;
    private double latitude;

    public Location(String address) {
        this.address = address;
        Map<String, Double> coords = OpenStreetMapUtil.getInstance().getCoordinates(address);
        try {
            longitude = coords.get("lon");
            latitude = coords.get("lat");
        } catch (Exception e) {
            System.out.println("Couldn't find the address' coordinates. Will use default ones.");
            longitude = 46.92119;
            latitude = 26.92646;
        }
    }

    public Location(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(Location that) {
        final int R = 6371; // Radius of the earth

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

    public String getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String toString() {
        return address + " (" + latitude + ", " + longitude + ")";
    }
}

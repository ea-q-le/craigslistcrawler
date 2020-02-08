package utilities;

import beans.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleAnalyzer {
    private static List<Vehicle> vehicles;
    private static long id;

    static {
        vehicles = new ArrayList<Vehicle>();
    }

    public static boolean analyzeAndAdd(String currentUrl, String header, String price, String details) {
        getId(currentUrl);

        if (!isNew()) return false;

        Vehicle vehicle = getVehicleDetails(header, price, details);
        vehicles.add(0, vehicle);

        return true;
    }

    public static Vehicle getVehicleDetails(String header, String price, String details) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(id);
        vehicle.setYear(getYear(header));
        vehicle.setMakeModel(getMakeModel(header));
        vehicle.setPrice(getPrice(price));
        vehicle.setOdometer(getOdometer(details));
        vehicle.setVin(getVIN(details));
        vehicle.setColor(getColor(details));
        vehicle.setTitle(getTitleStatus(details));
        vehicle.setDrivetrain(getDriveTrain(details));

        return vehicle;
    }

    public static int getYear(String header) {
        return Integer.parseInt(
                header.substring(0, 4)
        );
    }
    public static String getMakeModel(String header) {
        return header.substring(5);
    }
    public static int getPrice(String price) {
        return Integer.parseInt(
                price.substring(1)
        );
    }
    public static int getOdometer(String details) {
        if (details.contains("odometer")) {
            return Integer.parseInt(
                    details.substring(
                            details.indexOf("odometer: ") + 10,
                            details.indexOf(",", details.indexOf("odometer"))
                    )
            );
        }
        return -1;
    }
    public static String getVIN(String details) {
        if (details.contains("VIN")) {
            return details.substring(
                    details.indexOf("VIN: ") + 5,
                    details.indexOf(",", details.indexOf("VIN"))
            );
        }
        return "n/a";
    }
    public static String getColor(String details) {
        if (details.contains("color")) {
            return details.substring(
                    details.indexOf("color: ") + 7,
                    details.indexOf(",", details.indexOf("color"))
            );
        }
        return "n/a";
    }
    public static String getTitleStatus(String details) {
        if (details.contains("title status")) {
            return details.substring(
                    details.indexOf("title status: ") + 14,
                    details.indexOf(",", details.indexOf("title"))
            );
        }
        return "n/a";
    }
    public static String getDriveTrain(String details) {
        if (details.contains("drive:")) {
            return details.substring(
                    details.indexOf("drive: ") + 7,
                    details.indexOf(",", details.indexOf("drive:"))
            );
        }
        return "n/a";
    }

    public static boolean isNew() {
        for (Vehicle each: vehicles) {
            if (each.getId() == id)
                return false;
        }
        return true;
    }

    public static long getId(String currentUrl) {
        id = Long.parseLong(
                currentUrl.substring(
                        currentUrl.lastIndexOf("/") + 1,
                        currentUrl.indexOf(".html"))
        );
        return id;
    }

    public static List<Vehicle> getVehicles() {
        return vehicles;
    }
    public static long getId() {
        return id;
    }
}

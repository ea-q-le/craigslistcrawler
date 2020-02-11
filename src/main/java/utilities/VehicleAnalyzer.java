package utilities;

import beans.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class containing functions to analyze vehicle details
 * as extracted from ad page.
 *
 * @author Shahin 'Sean' Gadimov
 */
public class VehicleAnalyzer {
    private static List<Vehicle> vehicles;
    private static long currentID;

    static {
        vehicles = new ArrayList<Vehicle>(9);
    }

    /**
     * Given the currentUrl (obtained from vehicle ad page URL),
     *      header (obtained from vehicle ad page main header),
     *      price (obtained from vehicle ad page main header, if exists), and
     *      details (obtained from vehicle ad page parameters) as String literals,
     * the method
     *      validates that the vehicle has not been analyzed before (else, returns false),
     *      creates a Vehicle object,
     *      adds the Vehicle object into the 'vehicles' List as the first element, and
     *      returns 'true'.
     *
     * @param currentUrl as a String obtained from the vehicle ad page URL
     * @param header as a String obtained from vehicle header WebElement
     * @param price price as a String obtained from vehicle price WebElement (if exists)
     * @param details details as a String obtained from vehicle parameters WebElement
     * @return 'true' if the vehicle hasn't been evaluated before (doesn't exist in the List of 'vehicles')
     */
    public static boolean analyzeAndAdd(String currentUrl, String header, String price, String details) {
        getId(currentUrl);

        if (!isNew()) return false;

        Vehicle vehicle = getVehicleDetails(header, price, details);
        vehicle.setUrl(currentUrl);
        vehicles.add(0, vehicle);

        return true;
    }

    /**
     * Given String parameters (header, price, and details)
     * obtained from the WebElement texts,
     * the method internally calls utilities below and
     * returns a Vehicle object with ID, year, makeAndModel, price, odometer,
     *      VIN, color, titleStatus and odometer fields.
     *
     * @param header as a String obtained from vehicle header WebElement
     * @param price as a String obtained from vehicle price WebElement (if exists)
     * @param details as a String obtained from vehicle parameters WebElement
     * @return a Vehicle object
     */
    public static Vehicle getVehicleDetails(String header, String price, String details) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(currentID);
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

    /*
     * The methods below will return individual fields of a Vehicle object
     * given String parameters (header, price, and details) obtained from
     * the webpage.
     * Periodic maintenance might be necessary to validate the String that
     * is returned from WebElement analysis.
     */
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

    /**
     * Utilized internally (called within 'analyzeAndAdd()',
     * iterates through the List of vehicles,
     * returns 'false' if the 'currentID' is found in the List
     * meaning: the vehicle already exists in the List.
     *
     * @return 'true' if the currentID is NOT found in the List of vehicles
     */
    private static boolean isNew() {
        for (Vehicle each: vehicles) {
            if (each.getId() == currentID)
                return false;
        }
        return true;
    }

    /**
     * Given the current URL of the page,
     * the method extracts the add ID and returns it as a long.
     * e.g. "https://website/endpoint/numbersAsID.html"
     * will return 'numbersAsID' as a long.
     * The method assigns the ID to the 'currentID' field for further checks.
     *
     * @param currentUrl as a String
     * @return the ID extracted as the last digits from the endpoint
     */
    public static long getId(String currentUrl) {
        currentID = Long.parseLong(
                currentUrl.substring(
                        currentUrl.lastIndexOf("/") + 1,
                        currentUrl.indexOf(".html"))
        );
        return currentID;
    }

    public static List<Vehicle> getVehicles() {
        return vehicles;
    }
    public static long getCurrentID() {
        return currentID;
    }
}

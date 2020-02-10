package runner;

import beans.Specification;
import beans.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pages.CarsTrucksPage;
import pages.HomePage;
import pages.VehiclePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.SpecAnalyzer;
import utilities.VehicleAnalyzer;

public class MainTester {
	public static void main(String[] args) {
		Vehicle good1 = new Vehicle(2005, "toyota Rav4", 10000);
		Vehicle good2 = new Vehicle(2015, "Camry", 9999);
		Vehicle bad1 = new Vehicle(2004, "rav4", 1000);
		Vehicle bad2 = new Vehicle(2016, "rav4", 10000);
		Vehicle bad3 = new Vehicle(2010, "highlander", 10001);
		Vehicle bad4 = new Vehicle(2010, "ravv", 9000);
		
		System.out.println("Good: " + specAnalyzerTest(good1));
		System.out.println("Good: " + specAnalyzerTest(good2));
		System.out.println("Bad: " + specAnalyzerTest(bad1));
		System.out.println("Bad: " + specAnalyzerTest(bad2));
		System.out.println("Bad: " + specAnalyzerTest(bad3));
		System.out.println("Bad: " + specAnalyzerTest(bad4));
	}
	
	private static boolean specAnalyzerTest(Vehicle vehicle) {
		return SpecAnalyzer.matchesSpecification(vehicle);
	}
	
	private static void jsonFileTest() {
		ObjectMapper om = new ObjectMapper();
		List<Specification> specs = new ArrayList<Specification>();
		try {
			specs = om.readValue(new File("vehicle_specs.json"),
					new TypeReference<List<Specification>>() {
					});
		} catch (Exception e) {
			System.err.println("Ran into an EXCEPTION while deserializing");
			e.printStackTrace();
		}
		
		for (Specification each : specs)
			System.out.println(each);
	}
	
	private static void vehicleAnalysisTest() {
		
		HomePage.goToHomePage();
		new HomePage().carsTrucks4Sale.click();

		CarsTrucksPage page = new CarsTrucksPage();

		page.postedTodayCheckbox.click();

		do {
			BrowserUtils.wait(15);
			Driver.getDriver().navigate().refresh();
//			page = new CarsTrucksPage();
//System.out.println( page.nthAutoTitleText(2) );
//System.out.println( page.nthAutoPriceText(2) );

			for (int i = 1; i < 3; i++) {
				page.nthAutoTitle(i).click();

				String url = Driver.getDriver().getCurrentUrl();
//		SendEmail.sendEmailTo("sean.gadimoff@gmail.com", subject, url);
				System.out.println(url);

				VehiclePage vehiclePage = new VehiclePage();
				String header = vehiclePage.yearMakeModelInfo.getText();
				String details = BrowserUtils.webelementTextList(vehiclePage.attributesInfoList).toString();
				String price = "$-1";
				try {
					price = vehiclePage.priceInfo.getText();
				} catch (NoSuchElementException e) {
				}

//			Vehicle vehicle = VehicleAnalyzer.getVehicleDetails(header, price, details);
				boolean toAddOrNotToAdd = VehicleAnalyzer.analyzeAndAdd(url, header, price, details);
				if (!toAddOrNotToAdd) {
					System.out.println("NOT adding the vehicle and breaking the loop for the next iteration...");
					Driver.getDriver().navigate().back();
					break;
				}
//System.out.println(VehicleAnalyzer.analyzeAndAdd(url, header, price, details));
//System.out.println(vehicle.toString());
System.out.println(header);
System.out.println(details);
System.out.println(price);
//System.out.println(VehicleAnalyzer.getId(Driver.getDriver().getCurrentUrl()));
//
//System.out.println("Year: " + VehicleAnalyzer.getYear(header));
//System.out.println("Make model: " + VehicleAnalyzer.getMakeModel(header));
//System.out.println("Price: " + VehicleAnalyzer.getPrice(price));
//System.out.println("Odometer: " + VehicleAnalyzer.getOdometer(details));
//System.out.println("VIN: " + VehicleAnalyzer.getVIN(details));
//System.out.println("Color: " + VehicleAnalyzer.getColor(details));
//System.out.println("Title status: " + VehicleAnalyzer.getTitleStatus(details));
//System.out.println("Drivertrain: " + VehicleAnalyzer.getDriveTrain(details));

//System.out.println(VehicleAnalyzer.getId("https://washingtondc.craigslist.org/mld/ctd/d/fairfax-2011-volvo-xc70-lowest-prices/7070118114.html"));
//		Driver.closeDriver();

				Driver.getDriver().navigate().back();
			}

			System.out.println("Vehicles size: " + VehicleAnalyzer.getVehicles().size());

			for (Vehicle each : VehicleAnalyzer.getVehicles()) {
				System.out.println(each.toString());
			}

			System.out.println("Great success!");

		} while (true);

	}
}

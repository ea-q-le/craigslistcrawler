package runner;

import beans.Vehicle;
import org.openqa.selenium.NoSuchElementException;
import pages.CarsTrucksPage;
import pages.HomePage;
import pages.VehiclePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.VehicleAnalyzer;

public class MainTester {
	public static void main(String[] args) {
		
		HomePage.goToHomePage();
		new HomePage().carsTrucks4Sale.click();
		
		CarsTrucksPage page = new CarsTrucksPage();
				
		page.postedTodayCheckbox.click();
		
//System.out.println( page.nthAutoTitleText(2) );
//System.out.println( page.nthAutoPriceText(2) );

		for (int i = 1; i < 10; i++) {
			page.nthAutoTitle(i).click();

			String url = Driver.getDriver().getCurrentUrl();
//		SendEmail.sendEmailTo("sean.gadimoff@gmail.com", subject, url);
System.out.println(url);

			VehiclePage vehiclePage = new VehiclePage();
			String header = vehiclePage.yearMakeModelInfo.getText();
			String details = BrowserUtils
					.webelementTextList(vehiclePage.attributesInfoList)
					.toString();
			String price = "$-1";
			try { price = vehiclePage.priceInfo.getText(); } catch (NoSuchElementException e) {}

//			Vehicle vehicle = VehicleAnalyzer.getVehicleDetails(header, price, details);
System.out.println(VehicleAnalyzer.analyzeAndAdd(
		url,
		header,
		price,
		details
));
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

		for (Vehicle each : VehicleAnalyzer.getVehicles())
			System.out.println(each.toString());
		
System.out.println("Great success!");


	}
}

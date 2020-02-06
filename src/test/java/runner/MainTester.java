package runner;

import email.SendEmail;
import pages.CarsTrucksPage;
import pages.HomePage;
import pages.VehiclePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class MainTester {
	public static void main(String[] args) {
		
		HomePage.goToHomePage();
		new HomePage().carsTrucks4Sale.click();
		
		CarsTrucksPage page = new CarsTrucksPage();
				
		page.postedTodayCheckbox.click();
		
System.out.println( page.nthAutoTitleText(2) );
System.out.println( page.nthAutoPriceText(2) );
		
//		String subject = page.nthAutoTitleText(2) + " " + page.nthAutoPriceText(2);
		page.nthAutoTitle(2).click();
		
		String url = Driver.getDriver().getCurrentUrl();
//		SendEmail.sendEmailTo("sean.gadimoff@gmail.com", subject, url);
		System.out.println(url);
		
		VehiclePage vehiclePage = new VehiclePage();
		
		System.out.println( vehiclePage.yearMakeModelInfo.getText() );
		System.out.println( BrowserUtils
				.webelementTextList(vehiclePage.attributesInfoList) );
		
		
System.out.println("Great success!");
	}
}

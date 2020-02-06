package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css = "[id=sss0]>li:nth-of-type(16)>a")
	public WebElement carsTrucks4Sale;
	
	public static void goToHomePage() {
		Driver.getDriver().get(
				ConfigReader.getProperty("homePageURL"));
	}
}

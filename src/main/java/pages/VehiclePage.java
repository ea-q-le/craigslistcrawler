package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class VehiclePage {
	public VehiclePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (css = ".attrgroup:nth-of-type(1)>span>b")
	public WebElement yearMakeModelInfo;
	
	@FindBys ({
		@FindBy (css = ".attrgroup:nth-of-type(2)>span")
	})
	public List<WebElement> attributesInfoList;

	@FindBy (className = "price")
	public WebElement priceInfo;
}

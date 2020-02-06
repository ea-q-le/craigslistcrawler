package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CarsTrucksPage {
	public CarsTrucksPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (css = ".postedToday>input")
	public WebElement postedTodayCheckbox;
	
	@FindBy (name = "min_price")
	public WebElement minPriceInput;
	
	@FindBy (name = "max_price")
	public WebElement maxPriceInput;
	
	@FindBy (name = "auto_make_model")
	public WebElement makeAndModelInput;
	
	@FindBy (name = "min_auto_year")
	public WebElement minYearInput;
	
	@FindBy (name = "max_auto_year")
	public WebElement maxYearInput;
	
	@FindBy (name = "min_auto_miles")
	public WebElement minOdometerInput;
	
	@FindBy (name = "max_auto_miles")
	public WebElement maxOdometerInput;
	
	public WebElement nthAutoTitle(int n) {
		return Driver.getDriver()
				.findElement(By
						.cssSelector(
								nthAutoSelectorWithSuffix(
										".result-row", 
										n, 
										">p>a:nth-of-type(1)")));
	}
	
	public WebElement nthAutoPrice(int n) {
		return Driver.getDriver()
				.findElement(By
						.cssSelector(
								nthAutoSelectorWithSuffix(
										".result-row", 
										n, 
										">p>span:nth-of-type(2)>span:nth-of-type(1)")));
	}
	
	public String nthAutoTitleText(int n) {
		return nthAutoTitle(n).getText();
	}
	
	public String nthAutoPriceText(int n) {
		return nthAutoPrice(n).getText();
	}
	
	private static String nthAutoSelector(String css, int n) {
		return css + ":nth-of-type(" + n + ")";
	}
	private static String nthAutoSelectorWithSuffix(String css, int n, String suffix) {
		return nthAutoSelector(css, n) + suffix;
	}

	/*
	public static void main(String[] args) {
		System.out.println( nthAutoSelector(".result-row", 2) );
		System.out.println( nthAutoSelectorWithSuffix(".result-row", 2, ">a") );
	}
	*/
}

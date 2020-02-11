package utilities;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * Consists of common utility functions that can be handy for
 * browser related manipulations.
 *
 * @author Shahin 'Sean' Gadiomov
 */
public class BrowserUtils {
	public static final boolean ISWINDOWS;
	public static final boolean ISMAC;

	static {
		ISWINDOWS = System.getProperty("os.name").toLowerCase().contains("windows");
		ISMAC = System.getProperty("os.name").toLowerCase().contains("mac");
	}

	public static boolean verifyTextMatches(String str1, String str2) {
		return str1.equals(str2);
	}

	public static boolean verifyTextContains(String str1, String str2) {
		return str1.contains(str2);
	}

	public static void wait(int secs) {
		try {
			Thread.sleep(1000 * secs);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Given List<WebElement>, returns the List<String> of texts of the
	 * elements by .getText()
	 * 
	 * @param elements as List<WebElement>
	 * @return List<String>
	 */
	public static List<String> webelementTextList(List<WebElement> elements) {
		List<String> retList = new ArrayList<String>();
		for (WebElement each : elements)
			retList.add( each.getText() );
		return retList;
	}

}

package seleniumsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectWithSelectClassonly {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// dropdown - select tag
		// use Select class from selenium

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		By country = By.id("Form_submitForm_Country");
//		Select select = new Select(driver.findElement(country));
//		List<WebElement> optionsList = select.getOptions();
//		for(WebElement e: optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("India")) {
//				e.click();
//				break;				
//			}
//		}
//		doSelectValueUsingOptions(country,"India");
		
		By countryOptions = By.cssSelector("select#Form_submitForm_Country option");
		//xpath: //select[@id='Form_submitForm_Country']/option
//		List<WebElement> optionsList = driver.findElements(countryOptions);
//		for(WebElement e: optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		doSelectValueFromDropDown(countryOptions,"India");
				
	}
	
	public static void doSelectValueUsingOptions(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e: optionsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;				
			}
		}
		
	}
	
	public static void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e: optionsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}

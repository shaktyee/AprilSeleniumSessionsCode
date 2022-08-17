package seleniumsession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
//		List<WebElement> links = driver.findElements(By.xpath("//div[@class='block_content toggle-footer']//a"));
//		for(WebElement e:links) {
//			String linkText = e.getText();
//			System.out.println(linkText);
//			if(linkText.contains("My addresses")) {
//				e.click();
//				break;
//			}
//		}
		
		By linkLoc = By.xpath("//div[@class='block_content toggle-footer']//a");
		List<String> allLinkName = getLinkName(linkLoc);
		System.out.println(allLinkName.size());
		
		clickSpecificText("My addresses",linkLoc);
		
	
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getLinkName(By locator) {
		List<WebElement> eleLinks = getElements(locator);
		List<String> allTexts = new ArrayList<String>();
		for(WebElement e: eleLinks) {
			String eleText = e.getText();
			System.out.println(eleText);
			allTexts.add(eleText);
		}
		return allTexts;
	}
	
	public static void clickSpecificText(String match,By locator) {
		List<WebElement> eleLinks = getElements(locator);
		for(WebElement e:eleLinks) {
			String txt = e.getText();
			if(txt.contains(match)) {
				e.click();
				break;
			}
		}
	}
	
	
	
}

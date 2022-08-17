package seleniumsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {
	
	static WebDriver driver;

	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.google.com");
	
//	List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//	
//	for(WebElement e: langLinks) {
//		String text = e.getText();
//		System.out.println(text);
//		if(text.contains("മലയാളം")) {
//			e.click();
//			break;
//		}
//	}
	
	By footer = By.xpath("//div[@id='SIvCob']/a");
	footerClick(footer,"മലയാളം");	
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void footerClick(By footer,String lang) {
		List<WebElement> langLinks = getElements(footer);
		for(WebElement e: langLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(lang)) {
				e.click();
				break;
			}
		}
	}

	
}

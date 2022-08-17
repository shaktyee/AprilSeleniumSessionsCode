package seleniumsession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeListConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	
	//total links on the page and return the href list
	
//	List<WebElement> linksList = driver.findElements(By.tagName("a"));
//	
//	for(WebElement e : linksList) {
//		String hrefVal = e.getAttribute("href");
//		System.out.println(hrefVal);
//	}
	
	By links = By.tagName("a");
	By images = By.tagName("img");
	
	List<String> allLinks = getEleAttributeList(links,"href");
//	System.out.println(allLinks);
	for(String s: allLinks) {
		System.out.println(s);
	}
	
	List<String> imgAlt = getEleAttributeList(images,"alt");
	for(String s: imgAlt) {
		System.out.println(s);
	}

	List<String> imgHeight = getEleAttributeList(images,"height");
	for(String s: imgHeight) {
		System.out.println(s);
	}
	
	driver.quit();
		
	}
	
	public static List<String> getEleAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrValList = new ArrayList<String>();
		for(WebElement e:eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrValList.add(attrValue);
		}
		return eleAttrValList;
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}

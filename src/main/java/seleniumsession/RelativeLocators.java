package seleniumsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement baseEle = driver.findElement(By.linkText("Peterborough, Canada"));
		String right = driver.findElement(RelativeLocator.with(By.tagName("p")).toRightOf(baseEle)).getText();
		System.out.println(right);
		
		String left = driver.findElement(RelativeLocator.with(By.tagName("p")).toLeftOf(baseEle)).getText();
		System.out.println(left);
		
		String above = driver.findElement(RelativeLocator.with(By.tagName("p")).above(baseEle)).getText();
		System.out.println(above);
		
		String below = driver.findElement(RelativeLocator.with(By.tagName("p")).below(baseEle)).getText();
		System.out.println(below);
		
		String near = driver.findElement(RelativeLocator.with(By.tagName("p")).near(baseEle)).getText();
		System.out.println(near);
		
		List<WebElement> belowEles = driver.findElements(RelativeLocator.with(By.tagName("p")).below(baseEle));
		for(WebElement e: belowEles) {
			System.out.println(e.getText());
		}
		
		
		driver.quit();
	}

}

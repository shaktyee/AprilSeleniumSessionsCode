package seleniumsession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowTogether {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String pw = driver.getWindowHandle();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("img[alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			if(!windowID.equals(pw)) {
				System.out.println(driver.getTitle());
				driver.close();
			}
			Thread.sleep(2000);
		}
		driver.switchTo().window(pw);
		System.out.println("parent window title: " + driver.getTitle());		
		driver.quit();
	}

}

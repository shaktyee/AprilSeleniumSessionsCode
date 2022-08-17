package seleniumsession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		//set to list:
		List<String> handlesList = new ArrayList<String>(handles);
		String pw = handlesList.get(0);
		String cw = handlesList.get(1);
		
		System.out.println("parent window id is:"+pw);
		System.out.println("child window id is:"+cw);
		
		driver.switchTo().window(cw);
		System.out.println("child window name is "+driver.getTitle());
		driver.close();	//close child window
		
		driver.switchTo().window(pw);
		System.out.println("parent window name is "+driver.getTitle());
		driver.quit();
	}

}

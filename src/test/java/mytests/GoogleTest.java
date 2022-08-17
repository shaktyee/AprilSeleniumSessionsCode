package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{

	@Test(priority = 1,enabled = true)
	public void titleTest() {
//		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void searchFieldTest() {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}
}

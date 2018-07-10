package by.htp.test;

import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SimpleGoogleTest {
	
	private WebDriver driver;
	public static final String CHROME_PATH = "/Users/elenaskorodilo/Documents/chromedriver";
	public static final String CHROME = "webdriver.chrome.driver";
	
	@Before
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}
	
	@Test
	public void testSearchFieldExists() throws InterruptedException {
		driver.get("http://google.com");
		WebElement searchField = driver.findElement(By.name("q"));
		
		assertTrue(searchField.isDisplayed());
		Assert.assertNotNull(searchField);

		searchField.sendKeys("java");
		searchField.submit();
		
//		List<WebElement> searchResults = driver.findElements(By.className("g"));
		String resultTabTitle = driver.getTitle();
		
		assertTrue(resultTabTitle.contains("java"));
		
		
		
	}
	
	
	

}

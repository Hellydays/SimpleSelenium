package by.htp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutBy {
	
	private WebDriver driver;
	public static final String CHROME_PATH = "/Users/elenaskorodilo/Documents/chromedriver";
	public static final String CHROME = "webdriver.chrome.driver";
	
	@Before
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}
	
	@Test
	public void count() {
		driver.get("https://www.tut.by/");
		WebElement mainNews = driver.findElement(By.className("entry-head"));
		mainNews.click();	
		
		WebElement article = driver.findElement(By.id("article_body"));
		List<WebElement> list = article.findElements(By.tagName("p"));
		int amount = list.size();
		
		System.out.println(amount);
		
		driver.close();
		
	}

}

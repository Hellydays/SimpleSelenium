package by.htp.test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Academy {

	private WebDriver driver;
	public static final String CHROME_PATH = "/Users/elenaskorodilo/Documents/chromedriver";
	public static final String CHROME = "webdriver.chrome.driver";

	@Before
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}

	@Test
	public void learn() throws InterruptedException {
		
		driver.get("https://www.it-academy.by/");
		driver.manage().window().maximize();
		
		WebElement learn = driver.findElement(By.xpath("//div/ul/li/a/span[contains(text(), 'Обучение')]"));
		Actions action = new Actions(driver);
		action.moveToElement(learn).build().perform();
		
		List<WebElement> subMenuTitles = driver
				.findElements(By.xpath("/html/body/div[1]/main/section[1]/section[1]/div/ul/li"));
		
		WebElement precourses = null;
		
		for(WebElement element : subMenuTitles) {
			WebElement title = element.findElement(By.xpath("a/span"));
			System.out.println(title.getText().replaceAll("\\u00AD", ""));
			
			List<WebElement> subsub = element.findElements(By.xpath("ul/li"));
			for(WebElement el : subsub) {
				WebElement t =el.findElement(By.xpath("a"));
				String tit = t.getText();
				System.out.println(" - " + tit);
				if(tit.equals("Подготовительные курсы")) {
					precourses = t;
				}
			}
		}
		if(precourses!=null) {
			precourses.click();
			List<WebElement> course = driver
					.findElements(By.xpath("/html/body/div[1]/main/section[2]/div/div/section[1]/div"));
			for (WebElement e : course) {

				System.out.println(e.findElement(By.xpath("h2")).getText());
				try {
					WebElement dd = e.findElement(By.xpath("div[3]/div/div[1]/div"));
					System.out.println(dd.getText());
				} catch (NoSuchElementException ex) {
					System.out.println("No start date");
				}
		}
		
		 
	
		}
	}

}

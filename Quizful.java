package by.htp.test;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quizful {
	
	private WebDriver driver;
	public static final String CHROME_PATH = "/Users/elenaskorodilo/Documents/chromedriver";
	public static final String CHROME = "webdriver.chrome.driver";
	
	@Before
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}
	
	@Test
	public void register() throws InterruptedException {
		driver.get("http://www.quizful.net");
		
	
		WebElement registration = driver.findElement(By.xpath("/html/body/div[1]/ul[2]/li[3]/a"));
		registration.click();
		
		WebElement loginField = driver.findElement(By.id("login"));
		loginField.sendKeys("hellydays");
		
		WebElement passwordField = driver.findElement(By.name("registrationForm.password"));
		passwordField.sendKeys("123456");
		
		WebElement repeatPassField = driver.findElement(By.name("registrationForm.repassword"));
		repeatPassField.sendKeys("123456");
		
		WebElement emailField = driver.findElement(By.name("registrationForm.email"));
		emailField.sendKeys("hellydays776@gmail.com");
		
		WebElement corpCheckBox = driver.findElement(By.id("corporate"));
		corpCheckBox.click();
		
		Thread.sleep(7000);
		
		WebElement finishButton = driver.findElement(By.name("ok"));
		finishButton.click();
	 
	}

}

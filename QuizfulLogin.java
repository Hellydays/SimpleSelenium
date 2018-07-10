package by.htp.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizfulLogin {
	
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
		
		WebElement login = driver.findElement(By.xpath("/html/body/div[1]/ul[2]/li[1]/a"));
		login.click();
		
		WebElement loginField = driver.findElement(By.id("login"));
		loginField.sendKeys("hellydays776");
		
		WebElement passField = driver.findElement(By.name("loginForm.password"));
		passField.sendKeys("asxasxasx");
		
		WebElement enterBtn = driver.findElement(By.name("ok"));
		enterBtn.click();
		
		WebElement profileLink = driver.findElement(By.xpath("//html/body/div[1]/ul[2]/li[1]/b/a"));
		profileLink.click();
		
		WebElement editBtn = driver.findElement(By.xpath("//div[@class=\"btn-group\"]/a"));
		editBtn.click();
		
		WebElement privateData = driver.findElement(By.xpath("//b[contains(text(), 'Личные данные')]"));
		privateData.click();
		
		driver.findElement(By.name("personalForm.name")).sendKeys("Helly");
		driver.findElement(By.name("personalForm.surname")).sendKeys("Days");
		driver.findElement(By.name("personalForm.birthyear")).sendKeys("1995");
		driver.findElement(By.name("personalForm.site")).sendKeys("//link");
		driver.findElement(By.name("personalForm.company")).sendKeys("company");
		
		WebElement dropCountry = driver.findElement(By.name("personalForm.countryId"));
		Select country = new Select(dropCountry);
		country.selectByVisibleText("Беларусь");
		
		WebElement dropTime = driver.findElement(By.name("personalForm.zone"));
		Select timezone = new Select(dropTime);
		timezone.selectByVisibleText("Белоруссия/Минск(GMT+3)");
		
		driver.findElement(By.name("personalForm.about")).sendKeys("about me");
		
		String filepath = "/Users/elenaskorodilo/Documents/rose.jpg";
		WebElement attach = driver.findElement(By.name("personalForm.avatar"));
		attach.sendKeys(filepath);
		
		
		WebElement notifications = driver.findElement(By.xpath("//b[contains(text(), 'Уведомления')]"));
		notifications.click();
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("notificationsForm.notificationsEnabled"))).click();;
		
		WebElement emailCheckBox = driver.findElement(By.name("notificationsForm.deliveryEnabled"));
		emailCheckBox.click();
		
		WebElement conf = driver.findElement(By.xpath("//b[contains(text(), 'Конфиденциальность')]"));
		conf.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("privacyForm.profileVisibility")));
		
		WebElement justMe = driver.findElement(By.xpath("//input[@value=\"closed\"]"));
		justMe.click();	
		
	
	}

}

package DesignPatterns.FactoryPattern;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryDesignTestCaseOne {
	
	DriverManager driverManager;
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
	driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
	driver=driverManager.getDriver();
	}


	@Test
	public void verifyBStackDemoAddToCart() {
	driver.get("https://bstackdemo.com/");
//	List<WebElement> addToCartBtns = driver.findElements(By.cssSelector("div.shelf-item__buy-btn"));
//	addToCartBtns.get(0).click();
//	WebElement chkoutbtn = driver.findElement(By.cssSelector("div.buy-btn"));
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	Assert.assertTrue(chkoutbtn.isDisplayed());
	}
	
	@Test
	public void verifyBStackDemoTitle() {
	driver.get("https://facebook.com/");
//	Assert.assertEquals(driver.getTitle(), "StackDemo");
	}

	@Test
	public void verifyBStackDemoLogo() {
	driver.get("https://google.com/");
//	WebElement logo = driver.findElement(By.cssSelector(" a.Navbar_logo__26S5Y"));
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	Assert.assertTrue(logo.isDisplayed());
	}

	@AfterTest
	public void afterMethod() {
	driver.quit();
	}
	

}

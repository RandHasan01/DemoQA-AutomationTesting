package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ConfigReader.loadProperties();

		driver = DriverFactory.initializeDriver();

		String baseUrl = ConfigReader.getProperty("baseUrl");
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.quitDriver();
	}
}

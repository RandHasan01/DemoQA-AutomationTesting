package pages;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {
	WebDriver driver;

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By alertsElement = By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");
	private By alertsOptionLocator = By.xpath("//span[text()='Alerts']");
	private By alertButtonLocator = By.id("alertButton");
	private By timerAlertButtonLocator = By.id("timerAlertButton");
	private By confirmButtonLocator = By.id("confirmButton");
	private By promtButtonLocator = By.id("promtButton");
	private By confirmButtonResultLocator = By.id("confirmResult");
	private By promtButtonResultLocator = By.id("promptResult");

	public void openAlertsPage() {
		WebElement alertsCard = driver.findElement(alertsElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertsCard);

		alertsCard.click();
		WebElement alertsOption = driver.findElement(alertsOptionLocator);
		alertsOption.click();
	}

	public String clickAlertButton() {
		WebElement alertsButton = driver.findElement(alertButtonLocator);
		alertsButton.click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertText;
	}

	public String clickTimerAlertButton() {
		WebElement timerAlertButton = driver.findElement(timerAlertButtonLocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timerAlertButton);

		timerAlertButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertText;

	}

	public String clickConfirmButton() {
		WebElement confirmButton = driver.findElement(confirmButtonLocator);
		confirmButton.click();
		String alertText = driver.switchTo().alert().getText();
		return alertText;

	}

	public String verifyWhatYouChooseInConfirmAlerts(boolean accept) throws InterruptedException {
		if (accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}

		WebElement confirmButtonResult = driver.findElement(confirmButtonResultLocator);
		Thread.sleep(2000);
		return confirmButtonResult.getText();
	}

	public String clickPromtButton(String name) {
		WebElement promtButton = driver.findElement(promtButtonLocator);

		promtButton.click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		return alertText;
	}

	public String verifyPromtButtonBehavior() throws InterruptedException {
		WebElement promtButtonResult = driver.findElement(promtButtonResultLocator);
		Thread.sleep(2000);
//		System.out.println(promtButtonResult.getText());
		return promtButtonResult.getText();
	}

}

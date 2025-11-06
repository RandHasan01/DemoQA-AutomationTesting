package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AlertsPage;

public class TestAlertsPage extends BaseTest {

	Random rand = new Random();

	@Test
	public void AlertsTest() throws InterruptedException {
		DataTest dataTest = new DataTest();
		AlertsPage alertsPage = new AlertsPage(driver);
		int randomIndex = rand.nextInt(dataTest.accept.length);
		alertsPage.openAlertsPage();
		Assert.assertEquals(alertsPage.clickAlertButton(), "You clicked a button");
		Assert.assertEquals(alertsPage.clickTimerAlertButton(), "This alert appeared after 5 seconds");
		Assert.assertEquals(alertsPage.clickConfirmButton(), "Do you confirm action?");

		String expectedStatement = dataTest.accept[randomIndex] ? "You selected Ok" : "You selected Cancel";
		Assert.assertEquals(alertsPage.verifyWhatYouChooseInConfirmAlerts(dataTest.accept[randomIndex]),
				expectedStatement);

		Assert.assertEquals(alertsPage.clickPromtButton(dataTest.name), "Please enter your name");
		Assert.assertEquals(alertsPage.verifyPromtButtonBehavior(), "You entered " + dataTest.name);

	}

}

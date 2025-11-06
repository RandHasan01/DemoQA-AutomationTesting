package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FormsPage;

public class TestFormsPage extends BaseTest {

	@Test
	public void testFillFormSuccessfully() throws InterruptedException {

		DataTest data = new DataTest();
		FormsPage formsPage = new FormsPage(driver);

		formsPage.openFormsPage();
		String firstName = formsPage.enterFirstName(data.firstNames);
		String lastName = formsPage.enterLastName(data.lastNames);
		String email = formsPage.enterYourEmail(data.emails);
		String gender = formsPage.selectRandomGender();
		String phone = formsPage.enterYourNumber(data.phoneNumbers);
		String birthDay = formsPage.selectRandomBirthDay();
		String subject = formsPage.enterYourSubject(data.subjects);
		List<String> hobbies = formsPage.selectRandomHobbie();
		String joinedHobbies = String.join(", ", hobbies);

		String picture = formsPage.choosePhoto(data.filePath);
		String address = formsPage.enterYourAddress(data.addresses);
		String state = formsPage.chooseYourState();
		String city = formsPage.chooseYourCity();

		List<String> modalValues = formsPage.getAllSubmittedValues();

		Assert.assertEquals(modalValues.get(0), firstName + " " + lastName);
		Assert.assertEquals(modalValues.get(1), email);
		Assert.assertEquals(modalValues.get(2), gender);
		Assert.assertEquals(modalValues.get(3), phone);
		Assert.assertEquals(modalValues.get(4), birthDay);
		Assert.assertEquals(modalValues.get(5), subject);
		Assert.assertEquals(modalValues.get(6), joinedHobbies);
		Assert.assertEquals(modalValues.get(7), picture);
		Assert.assertEquals(modalValues.get(8), address);
		Assert.assertEquals(modalValues.get(9), state);
		Assert.assertEquals(modalValues.get(10), city);

		formsPage.closeModal();

	}

}

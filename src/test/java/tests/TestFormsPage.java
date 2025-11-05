package tests;

import org.testng.annotations.Test;

import pages.FormsPage;

public class TestFormsPage extends BaseTest {

	@Test
	public void testFillFormSuccessfully() throws InterruptedException {

		DataTest data = new DataTest();
		FormsPage formsPage = new FormsPage(driver);

		formsPage.enterFirstName(data.firstNames);
		formsPage.enterLastName(data.lastNames);
		formsPage.enterYourEmail(data.emails);
		formsPage.selectRandomGender();
		formsPage.enterYourNumber(data.phoneNumbers);
		formsPage.selectRandomBirthDay();
		formsPage.enterYourSubject(data.subjects);
		formsPage.selectRandomHobbie();
		formsPage.choosePhoto(data.filePath);
		formsPage.enterYourAddress(data.addresses);
		formsPage.chooseYourState();
		formsPage.chooseYourCity();
		formsPage.clickSubmitButton();
		formsPage.closeModal();

	}

}//do assertion to check if the information transfar correctly in the submition modal

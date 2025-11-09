package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ElementsPage;

public class TestElementsPage extends BaseTest {

	@Test
	public void checkboxTest() throws InterruptedException {
		ElementsPage elementsPage = new ElementsPage(driver);

		elementsPage.openElementPage();
		List<String> selectedCheckboxes = elementsPage.selectNumberOfCheckbox();
		List<String> resutlOfCheckbox = elementsPage.getTheResult();

		selectedCheckboxes.replaceAll(String::toLowerCase);
		resutlOfCheckbox.replaceAll(String::toLowerCase);
		Assert.assertEquals(selectedCheckboxes, resutlOfCheckbox);
	}

}

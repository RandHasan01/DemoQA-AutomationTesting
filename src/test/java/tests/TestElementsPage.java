package tests;

import java.util.List;

import org.testng.annotations.Test;

import pages.ElementsPage;

public class TestElementsPage extends BaseTest {

	@Test
	public void checkboxTest() throws InterruptedException {
		DataTest dataTest = new DataTest();
		ElementsPage elementsPage = new ElementsPage(driver);

		elementsPage.openElementPage();
		List<String> selectedCheckboxes = elementsPage.selectNumberOfCheckbox();
		System.out.println(selectedCheckboxes);
		
		List<String> resutlOfCheckbox = elementsPage.getTheResult();
		System.out.println(resutlOfCheckbox);
	}

}

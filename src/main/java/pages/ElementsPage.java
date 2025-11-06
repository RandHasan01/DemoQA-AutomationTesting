package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage {

	private WebDriver driver;
	Random rand = new Random();

	public ElementsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By elementOption = By.xpath("//h5[normalize-space()='Elements']");
	private By checkboxOption = By.xpath("//span[text()='Check Box']");
	private By ExpandElement = By.cssSelector(".rct-option.rct-option-expand-all");
	private By checkboxsLocator = By.className("rct-title");
	private By resultLocator = By.className("text-success");

	public void openElementPage() throws InterruptedException {
		WebElement elementsCard = driver.findElement(elementOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsCard);
		elementsCard.click();
		Thread.sleep(2000);

		WebElement checkboxCard = driver.findElement(checkboxOption);
		checkboxCard.click();
		Thread.sleep(2000);

	}

	public List<String> selectNumberOfCheckbox() {
		WebElement expandButton = driver.findElement(ExpandElement);
		expandButton.click();
		List<WebElement> checkboxss = driver.findElements(checkboxsLocator);
		int randomClick = rand.nextInt(2, checkboxss.size());
		int steps = rand.nextInt(1, 6);
		List<String> selected = new ArrayList<String>();

		System.out.println("steps" + steps);
		System.out.println("randomClick" + randomClick);
		for (int i = 1; i < randomClick; i += steps) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkboxss.get(i));
			selected.add(checkboxss.get(i).getText());
			checkboxss.get(i).click();
		}
//		System.out.println(selected);
		return selected;
	}

	public List<String> getTheResult() {
		List<WebElement> resultElement = driver.findElements(resultLocator);
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < resultElement.size(); i++) {
			result.add(resultElement.get(i).getText());

		}
		return result;
	}
}

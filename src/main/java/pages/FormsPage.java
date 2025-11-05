package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormsPage {

	private WebDriver driver;
	private Random rand = new Random();

	public FormsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By formsCard = By.xpath("//h5[normalize-space()='Forms']");
	private By practiceFromsElement = By.xpath("//span[text()='Practice Form']");

	private By firstNameInput = By.id("firstName");
	private By lastNameInput = By.id("lastName");
	private By emailInput = By.id("userEmail");
	private By genderInput = By.id("genterWrapper");
	private By genderLabels = By.tagName("label");
	private By userNumberInput = By.id("userNumber");

	private By dateOfBirthInput = By.id("dateOfBirthInput");
	private By dateOfBirthPopper = By.className("react-datepicker-popper");
	private By monthDropdown = By.className("react-datepicker__month-select");
	private By yearDropdown = By.className("react-datepicker__year-select");
	private By monthSection = By.className("react-datepicker__month");
	private By weekRows = By.className("react-datepicker__week");
	private By daysInWeek = By.className("react-datepicker__day");

	private By subjectInput = By.id("subjectsInput");
	private By hobbiesCheckbox = By.id("hobbiesWrapper");
	private By uploadPicture = By.id("uploadPicture");

	private By currentAddressInput = By.id("currentAddress");
	private By stateSelect = By.id("state");
	private By citySelect = By.id("city");
	private By submitInput = By.id("submit");
	private By closeButton = By.id("closeLargeModal");
	private By seccessMessage = By.id("example-modal-sizes-title-lg");

	// Method

	public void enterFirstName(String[] firstNames) throws InterruptedException {
		WebElement forms = driver.findElement(formsCard);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forms);
		forms.click();
		Thread.sleep(2000);
		WebElement practiceFroms = driver.findElement(practiceFromsElement);
		practiceFroms.click();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(firstNameInput);
		int randomFirstName = rand.nextInt(firstNames.length);
		firstName.sendKeys(firstNames[randomFirstName]);
	}

	public void enterLastName(String[] lastNames) {
		WebElement lastName = driver.findElement(lastNameInput);
		int randomLastName = rand.nextInt(lastNames.length);
		lastName.sendKeys(lastNames[randomLastName]);
	}

	public void enterYourEmail(String[] emails) {
		WebElement email = driver.findElement(emailInput);
		int randomEmail = rand.nextInt(emails.length);
		email.sendKeys(emails[randomEmail]);
	}

	public void selectRandomGender() {
		WebElement genderSection = driver.findElement(genderInput);
		List<WebElement> options = genderSection.findElements(genderLabels);
		int randomIndex = rand.nextInt(options.size());
		options.get(randomIndex).click();
	}

	public void enterYourNumber(String[] phoneNumbers) {
		WebElement number = driver.findElement(userNumberInput);
		int randomNumber = rand.nextInt(phoneNumbers.length);
		number.sendKeys(phoneNumbers[randomNumber]);
	}

	public void selectRandomBirthDay() {
		WebElement birthDaySection = driver.findElement(dateOfBirthInput);
		birthDaySection.click();
		WebElement calenderPopper = driver.findElement(dateOfBirthPopper);

		WebElement monthElement = calenderPopper.findElement(monthDropdown);
		List<WebElement> months = monthElement.findElements(By.tagName("option"));
		Select monthSelect = new Select(monthElement);
		int randomMonth = rand.nextInt(months.size());
		monthSelect.selectByIndex(randomMonth);

		WebElement yearSelect = calenderPopper.findElement(yearDropdown);
		List<WebElement> years = yearSelect.findElements(By.tagName("option"));
		Select select = new Select(yearSelect);
		int randomYear = rand.nextInt(years.size());
		select.selectByIndex(randomYear);
		WebElement monthBlock = calenderPopper.findElement(monthSection);
		List<WebElement> weeks = monthBlock.findElements(weekRows);
		int randomWeek = rand.nextInt(weeks.size());
		List<WebElement> days = weeks.get(randomWeek).findElements(daysInWeek);
		int randomDay = rand.nextInt(days.size());
		days.get(randomDay).click();

	}

	public void enterYourSubject(String[] subjects) {
		WebElement subject = driver.findElement(subjectInput);
		int randomsubject = rand.nextInt(subjects.length);
		subject.sendKeys(subjects[randomsubject]);
		subject.sendKeys(Keys.ENTER);

	}

	public void selectRandomHobbie() {

		WebElement HobbieSection = driver.findElement(hobbiesCheckbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HobbieSection);

		List<WebElement> options = HobbieSection
				.findElements(By.cssSelector(".custom-control.custom-checkbox.custom-control-inline"));
		int randomClick = rand.nextInt(1,options.size());
		for (int i = 0; i < randomClick; i++) {
			options.get(i).click();
		}
	}

	public void choosePhoto(String filePath) {
		WebElement uploadInput = driver.findElement(uploadPicture);
		uploadInput.sendKeys(filePath);
	}

	public void enterYourAddress(String[] addresses) {

		WebElement adress = driver.findElement(currentAddressInput);
		int randomadress = rand.nextInt(addresses.length);
		adress.sendKeys(addresses[randomadress]);
	}

	public void chooseYourState() throws InterruptedException {
		WebElement state = driver.findElement(stateSelect);
		WebElement stateInput = state.findElement(By.id("react-select-3-input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);

		state.click();
		Thread.sleep(2000);
		stateInput.sendKeys(Keys.ENTER);
	}

	public void chooseYourCity() throws InterruptedException {
		WebElement city = driver.findElement(citySelect);
		WebElement cityInput = city.findElement(By.id("react-select-4-input"));
		city.click();
		Thread.sleep(2000);
		cityInput.sendKeys(Keys.ENTER);
	}

	public void clickSubmitButton() {
		WebElement submitButton = driver.findElement(submitInput);
		submitButton.click();
	}

	public void closeModal() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
		Thread.sleep(2000);
		WebElement Message = driver.findElement(seccessMessage);
		WebElement closeModal = driver.findElement(closeButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeModal);

		closeModal.click();
	}
	// Don't forget to check if the data is correct after submitted

}

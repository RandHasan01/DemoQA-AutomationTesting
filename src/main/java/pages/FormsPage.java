package pages;

import java.util.ArrayList;
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
	private String selectedFirstName;
	private By lastNameInput = By.id("lastName");
	private String selectedLastName;

	private By emailInput = By.id("userEmail");
	private String selectedEmail;

	private By genderInput = By.id("genterWrapper");
	private String selectedGender;

	private By genderLabels = By.tagName("label");
	private By userNumberInput = By.id("userNumber");
	private String selectedPhoneNumber;

	private By dateOfBirthInput = By.id("dateOfBirthInput");
	private String selectedBirthDay;

	private By dateOfBirthPopper = By.className("react-datepicker-popper");

	private By monthDropdown = By.className("react-datepicker__month-select");
	private By yearDropdown = By.className("react-datepicker__year-select");
	private By monthSection = By.className("react-datepicker__month");
	private By weekRows = By.className("react-datepicker__week");
	private By daysInWeek = By.className("react-datepicker__day");

	private By subjectInput = By.id("subjectsInput");
	private String selectedSubject;

	private By hobbiesCheckbox = By.id("hobbiesWrapper");

	private By uploadPicture = By.id("uploadPicture");
	private String selectedPicture;

	private By currentAddressInput = By.id("currentAddress");
	private String selectedAddress;

	private By stateSelect = By.id("state");
	private String selectedState;

	private By citySelect = By.id("city");
	private String selectedCity;

	private By submitInput = By.id("submit");
	private By closeButton = By.id("closeLargeModal");
	private By successMessage = By.id("example-modal-sizes-title-lg");

	// Method

	public void openFormsPage() throws InterruptedException {

		WebElement forms = driver.findElement(formsCard);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forms);
		forms.click();
		Thread.sleep(2000);
		WebElement practiceFroms = driver.findElement(practiceFromsElement);
		practiceFroms.click();
		Thread.sleep(2000);
	}

	public String enterFirstName(String[] firstNames) {

		WebElement firstName = driver.findElement(firstNameInput);
		int randomFirstName = rand.nextInt(firstNames.length);
		firstName.sendKeys(firstNames[randomFirstName]);
		selectedFirstName = firstNames[randomFirstName];
		return selectedFirstName;
	}

	public String enterLastName(String[] lastNames) {
		WebElement lastName = driver.findElement(lastNameInput);
		int randomLastName = rand.nextInt(lastNames.length);
		lastName.sendKeys(lastNames[randomLastName]);
		selectedLastName = lastNames[randomLastName];
		return selectedLastName;
	}

	public String enterYourEmail(String[] emails) {
		WebElement email = driver.findElement(emailInput);
		int randomEmail = rand.nextInt(emails.length);
		email.sendKeys(emails[randomEmail]);
		selectedEmail = emails[randomEmail];
		return selectedEmail;
	}

	public String selectRandomGender() {
		WebElement genderSection = driver.findElement(genderInput);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderSection);

		List<WebElement> options = genderSection.findElements(genderLabels);
		int randomIndex = rand.nextInt(options.size());
		options.get(randomIndex).click();
		selectedGender = options.get(randomIndex).getText();
		return selectedGender;
	}

	public String enterYourNumber(String[] phoneNumbers) {
		WebElement number = driver.findElement(userNumberInput);
		int randomNumber = rand.nextInt(phoneNumbers.length);
		number.sendKeys(phoneNumbers[randomNumber]);
		selectedPhoneNumber = phoneNumbers[randomNumber];
		return selectedPhoneNumber;
	}

	public String selectRandomBirthDay() {
		WebElement birthDaySection = driver.findElement(dateOfBirthInput);
		birthDaySection.click();
		WebElement calenderPopper = driver.findElement(dateOfBirthPopper);

		WebElement yearSelect = calenderPopper.findElement(yearDropdown);
		List<WebElement> years = yearSelect.findElements(By.tagName("option"));
		Select select = new Select(yearSelect);
		int randomYear = rand.nextInt(years.size());
		String yearValue = years.get(randomYear).getText();
		select.selectByIndex(randomYear);

		WebElement monthElement = calenderPopper.findElement(monthDropdown);
		List<WebElement> months = monthElement.findElements(By.tagName("option"));
		Select monthSelect = new Select(monthElement);
		int randomMonth = rand.nextInt(months.size());
		String monthName = months.get(randomMonth).getText();

		monthSelect.selectByIndex(randomMonth);

		WebElement monthBlock = calenderPopper.findElement(monthSection);
		List<WebElement> weeks = monthBlock.findElements(weekRows);
		int randomWeek = rand.nextInt(weeks.size());
		List<WebElement> days = weeks.get(randomWeek).findElements(daysInWeek);
		int randomDay = rand.nextInt(days.size());
		String dayText = days.get(randomDay).getText();
		days.get(randomDay).click();

		selectedBirthDay = dayText + " " + monthName + "," + yearValue;
		return selectedBirthDay;

	}

	public String enterYourSubject(String[] subjects) {
		WebElement subject = driver.findElement(subjectInput);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subject);
		subject.click();
		int randomsubject = rand.nextInt(subjects.length);
		subject.sendKeys(subjects[randomsubject]);
		selectedSubject = subjects[randomsubject];
		subject.sendKeys(Keys.ENTER);
		return selectedSubject;

	}

	public List<String> selectRandomHobbie() {

		WebElement HobbieSection = driver.findElement(hobbiesCheckbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HobbieSection);
		List<String> selectedHobbiesList = new ArrayList<>();

		List<WebElement> options = HobbieSection
				.findElements(By.cssSelector(".custom-control.custom-checkbox.custom-control-inline"));

		int randomClick = rand.nextInt(1, options.size() + 1);
		for (int i = 0; i < randomClick; i++) {
			WebElement option = options.get(i);
			WebElement label = option.findElement(By.tagName("label"));
			String hobbyName = label.getText();
			options.get(i).click();
			selectedHobbiesList.add(hobbyName);
		}
		return selectedHobbiesList;
	}

	public String choosePhoto(String filePath) {
		WebElement uploadInput = driver.findElement(uploadPicture);
		uploadInput.sendKeys(filePath);
		selectedPicture = filePath.substring(filePath.lastIndexOf("\\") + 1);
		return selectedPicture;

	}

	public String enterYourAddress(String[] addresses) {

		WebElement adress = driver.findElement(currentAddressInput);
		int randomadress = rand.nextInt(addresses.length);
		adress.sendKeys(addresses[randomadress]);
		selectedAddress = addresses[randomadress];
		return selectedAddress;
	}

	public String chooseYourState() throws InterruptedException {
		WebElement state = driver.findElement(stateSelect);
		WebElement stateInput = state.findElement(By.id("react-select-3-input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);

		state.click();
		Thread.sleep(2000);
		stateInput.sendKeys(Keys.ENTER);
		selectedState = state.findElement(By.cssSelector(".css-1uccc91-singleValue")).getText();
		return selectedState;
	}

	public String chooseYourCity() throws InterruptedException {
		WebElement city = driver.findElement(citySelect);
		WebElement cityInput = city.findElement(By.id("react-select-4-input"));
		city.click();
		Thread.sleep(2000);
		cityInput.sendKeys(Keys.ENTER);
		selectedCity = city.findElement(By.cssSelector(".css-1uccc91-singleValue")).getText();
		return selectedCity;
	}

	public void clickSubmitButton() {
		WebElement submitButton = driver.findElement(submitInput);
		submitButton.click();
	}

	public List<String> getAllSubmittedValues() {
		List<WebElement> values = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		List<String> textValues = new ArrayList<>();
		for (WebElement value : values) {
			textValues.add(value.getText());
		}
		return textValues;
	}

	public String closeModal() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
		Thread.sleep(2000);
		WebElement Message = driver.findElement(successMessage);
		WebElement closeModal = driver.findElement(closeButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeModal);

		closeModal.click();
		return Message.getText();
	}

}

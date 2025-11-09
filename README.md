# 🧪 DemoQA-AutomationTesting

This project is an automation testing framework built using **Java**, **Selenium**, **TestNG**, and **Maven**.  
It automates testing on the [DemoQA](https://demoqa.com/) website following the **Page Object Model (POM)** design pattern.  
The framework was created to validate multiple UI scenarios such as **Forms**, **Check Box**, and **Alerts**.

---

## 🚀 How to Run the Tests

### 🧩 Requirements
- Java 8 or higher  
- Maven  
- TestNG plugin in Eclipse  
- Google Chrome and compatible ChromeDriver  

### ▶️ Steps to Execute
1. Open the project in **Eclipse**.  
2. Allow **Maven** to download dependencies automatically.  
3. Run any test by right-clicking on the test class (e.g., `TestFormsPage.java`) →  
   **Run As → TestNG Test**.  

---


# ⚙️ Assumptions and Limitations
- Tests are executed on the Google Chrome browser.

- The target website (DemoQA) is dynamic and may occasionally change,which could require updating locators.

- No reporting tools or parallel execution are implemented the focus is on simplicity and framework structure.

- Built as a learning framework, easily extendable with reporting or cross-browser testing in the future.

---  
  
## 🧱 Framework Structure

```bash
DemoQA/
│
├── src/
│   ├── main/
│   │   ├── resources/
│   │   │   ├── config.properties
│   │   ├── java/
│   │   │   ├── pages/          # Page Object Model classes
│   │   │   │   ├── FormsPage.java
│   │   │   │   ├── CheckBoxPage.java
│   │   │   │   └── AlertsPage.java
│   │   │   ├── utils/ 
│   │   │   │   ├── DriverFactory.java
│   │   │   │   └── ConfigReader.java
│   │
│   └── test/
│   │   ├── resources
│   │   |    └── Images
│   │   │    |   ├── profile.jpg
│   │   └── java/tests/          # TestNG test classes
│   │   |   ├── DataTest.java
│   │   |   ├── BaseTest.java
│   │   |   ├── TestFormsPage.java
│   │   |   ├── TestCheckBoxPage.java
│   │   |   └── TestAlertsPage.java
│
├── pom.xml                       # Maven configuration file
└── README.md                     # Project documentation

🧠 The framework follows the Page Object Model (POM) design pattern to improve code readability, reusability, and maintenance.

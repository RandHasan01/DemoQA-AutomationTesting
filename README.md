# 🧪 DemoQA-AutomationTesting

A simple automation testing framework using **Java**, **Selenium**, **TestNG**, and **Maven**  
for testing [DemoQA](https://demoqa.com).

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

## 🧱 Framework Structure

```bash
DemoQA-AutomationTesting/
│
├── src/
│   ├── main/java/pages/          # Page Object Model classes
│   │   ├── BasePage.java
│   │   ├── FormsPage.java
│   │   ├── CheckBoxPage.java
│   │   └── AlertsPage.java
│   │
│   └── test/java/tests/          # TestNG test classes
│       ├── BaseTest.java
│       ├── TestFormsPage.java
│       ├── TestCheckBoxPage.java
│       └── TestAlertsPage.java
│
├── pom.xml                       # Maven configuration file
└── README.md                     # Project documentation


🧠 The framework follows the Page Object Model (POM) design pattern to improve code readability, reusability, and maintenance.

---

# ⚙️ Assumptions and Limitations
- Tests are executed on the Google Chrome browser.

- The target website (DemoQA) is dynamic and may occasionally change,which could require updating locators.

- No reporting tools or parallel execution are implemented the focus is on simplicity and framework structure.

- Built as a learning framework, easily extendable with reporting or cross-browser testing in the future.

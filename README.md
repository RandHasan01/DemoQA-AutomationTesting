# 🧪 DemoQA-AutomationTesting

---

## 🚀 **How to Run the Tests**

This automation testing framework was built using **Java**, **Selenium**, **TestNG**, and **Maven**.  
To run the tests, make sure you have the following installed:

- **Java 8 or higher**  
- **Maven**  
- **TestNG plugin** in Eclipse  
- **Google Chrome** and a matching **ChromeDriver**

### **Steps to Execute**
1. Open the project in **Eclipse**.  
2. Let **Maven** download the required dependencies automatically.  
3. Run any test by right-clicking on the test class (e.g., `TestFormsPage.java`) →  
   **Run As → TestNG Test**.

## 🧱 Framework StructureDemoQA-AutomationTesting/
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


The framework follows the **Page Object Model (POM)** design pattern  
to improve code readability, reusability, and maintenance.

---

## ⚙️ Assumptions and Limitations

- Tests are designed and executed on the **Google Chrome** browser.  
- The website under test ([DemoQA](https://demoqa.com)) is dynamic and may change occasionally,  
  which could require updating locators.  
- No reporting tools or parallel execution are implemented —  
  the focus is on simplicity and structure.  
- The framework follows **POM** to maintain clarity and modularity.

---



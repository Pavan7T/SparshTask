# ZenInbox Automation Test Framework

## Setup Instructions:
1. Clone this https://github.com/Pavan7T/SparshTask repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Use Maven to resolve dependencies.
4. In the testcase class, update the driver browser as you wish.
I was using FirefoxDriver() at the moment.

## How to Run Tests:
Method 1:
1. Open the project in your IDE.
2. Right-click on the test class (e.g., `ZenInboxTests.java`) and select "Run".
3. The tests will run, and the results will be reported in an HTML file `extentReport.html`.

Method 2

1. Ensure that Maven and allure windows applications are installed on ypur machine as prerequisits
2. Open project file location enter in it, open command Promt in it. 
3. Run command "mvn compile" to build the project
4. Run command "mvn test" to run the test cases using CMD itself
5. for reports go to allure report folder and copy report folder path
6. run cmd commd "allure serve c/projrct/path"
7. allure reports will be opn in browser.

## Approach:
- Functional test cases ensure that key application features (login, inbox, search, settings) work as expected.
- Non-functional tests focus on performance, security, and edge cases.
- Selenium WebDriver is used for interacting with the ZenInbox application.
- TestNG is used for organizing and managing test execution, and ExtentReports is used for generating detailed test reports.


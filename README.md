# Automation-Practice
 
Hi,

Here's a test I created using Selenium webdriver and Java. I am using a Maven project structure with TestNG plugin to run my tests.
The design pattern is Page Object Model.
The scenario is driven by a data-provider framework (CSV file).  Test inputs are therefore stored separately from the test. So the test cases can be executed with different data without changing the test itself.

I will be testing the website “http://automationpractice.com/index.php” following a this steps to reproduce:
1. Go to http://automationpractice.com/index.php
2. Search for an item (taken from the CSV file)
3. Select random item from all available items
4. Open cart
5. Assert that item quantity and total price are correct
6. Proceed to checkout
7. Create new account using information taken from the CSV file
8. Assert in address page that all information are correct
9. Accept "Terms of Services"
10. Pay with bank wire method
11. Assert order is complete

Here is a small documentation regarding the setup required and how to launch the tests.
In order to run the test, you'll need the following setup:
- Java version 1.8.0
- jdk-11.0.6
- Chrome browser version 90
- Firefox browser version 87.0 (64-bit)
- Eclipse IDE

You will find 1 test suite XML files under "src\test\resources\TestSuites":
- ExerciseASuite.xml

To run the tests:
- Right click on one of those files
- "Run as"
- TestNG Suite

As for the report, you can find it under "automation-exercise\test-output\emailable-report.html", "automation-exercise\test-output\index.html" or finally "automation-exercise\test-output\testng-results.xml"

The screenshots (in case of test failures) will be under: "automation-exercise\test-output\screenshots"

Finally, if you wish to run the test many times automatically, I left the "@Test(invocationCount = X)" parameter available above the test method's name. Just edit this parameter to your liking.

That's it! Thanks for reading me :) Nicolas

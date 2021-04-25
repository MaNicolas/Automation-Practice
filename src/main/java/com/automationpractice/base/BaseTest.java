package com.automationpractice.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners({com.automationpractice.base.TestListener.class})
public class BaseTest {

	// Variables
	protected WebDriver driver;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	// Methods
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(Method method, @Optional("chrome") String browser, ITestContext ctx) {
		Reporter.log("Launching browser.");
		String testName = ctx.getCurrentXmlTest().getName();
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		driver.manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close browser
		Reporter.log("Closing browser.");
		driver.quit();
	}
}
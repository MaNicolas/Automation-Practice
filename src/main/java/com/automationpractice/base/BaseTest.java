package com.automationpractice.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
		String testName = ctx.getCurrentXmlTest().getName();
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		driver.manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//		// Close browser
//		driver.quit();
//	}
}
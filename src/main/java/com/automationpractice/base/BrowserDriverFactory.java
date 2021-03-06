package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserDriverFactory {

	// Variables
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	// Constructor
	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	// Methods
	public WebDriver createDriver() {
		// Create driver
		Reporter.log("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			Reporter.log("Starting chrome browser.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			Reporter.log("Starting firefox browser.");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;

		default:
			Reporter.log("Do not know how to start " + browser + ", starting chrome browser instead!");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get();
	}
}
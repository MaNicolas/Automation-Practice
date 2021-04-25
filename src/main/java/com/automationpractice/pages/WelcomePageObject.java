package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class WelcomePageObject extends HeaderPageObject {

	// Variables
	private String pageUrl = "http://automationpractice.com/index.php";	

	// Constructor
	public WelcomePageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void openPage() {
		Reporter.log("Opening page: " + pageUrl);
		openUrl(pageUrl);
		Reporter.log("Page opened!");
	}	
}
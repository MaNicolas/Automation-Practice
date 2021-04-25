package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPageObject extends HeaderPageObject{

	//Locators
	private By createEmailAddressLocator = By.xpath("//input[@name='email_create']");
	private By createAccountButtonLocator = By.id("SubmitCreate");
	
	//Constructor
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public AccountCreationPageObject createAnAccount(String emailAddress) {
		Reporter.log("Creating new account using random Email address: " + emailAddress);
		type(emailAddress, createEmailAddressLocator, 5);
		click(createAccountButtonLocator, 3);
		return new AccountCreationPageObject(driver);
	}
}
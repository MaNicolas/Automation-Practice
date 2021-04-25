package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class AddressPageObject extends HeaderPageObject{

	//Locators
	private By checkoutButtonLocator = By.xpath("//button[@name='processAddress']");
	
	//Constructor
	public AddressPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public ShippingPageObject clickCheckoutButton() {
		click(checkoutButtonLocator, 3);
		return new ShippingPageObject(driver);
	}
}
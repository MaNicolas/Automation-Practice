package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class PopupPageObject extends HeaderPageObject {

	// Variables
	private By checkOutbuttonLocator = By.xpath("//a[@title='Proceed to checkout']");

	// Constructor
	public PopupPageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public CartPageObject goToCart(){
		Reporter.log("Going to cart.");
		click(checkOutbuttonLocator, 3);
		return new CartPageObject(driver);
	}
}
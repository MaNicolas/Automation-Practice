package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPageObject extends HeaderPageObject{

	//Locators
	private By checkBoxLocator = By.id("uniform-cgv");
	private By checkoutButtonLocator = By.xpath("//button[@name='processCarrier']");
	
	//Constructor
	public ShippingPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public void selectCheckBox() {
		WebElement checkBox = find(checkBoxLocator);
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
	}
	
	public PaymentPageObject clickCheckoutButton() {
		click(checkoutButtonLocator, 3);
		return new PaymentPageObject(driver);
	}
}
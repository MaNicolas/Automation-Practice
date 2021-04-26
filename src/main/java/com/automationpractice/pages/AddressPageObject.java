package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends HeaderPageObject{

	//Locators
	private By completeNameLocator = By.xpath("(//li[@class='address_firstname address_lastname'])[1]");
	private By addressLocator = By.xpath("(//li[@class='address_address1 address_address2'])[1]");
	private By phoneNumberLocator = By.xpath("(//li[@class='address_phone_mobile'])[1]");
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
	
	public String getcompleteName() {
		return find(completeNameLocator).getText();
	}
	
	public String getDeliveryAddress() {
		return find(addressLocator).getText();
	}
	
	public String getPhoneNumber() {
		return find(phoneNumberLocator).getText();
	}
}
package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPageObject extends HeaderPageObject {

	//Locators
	private By firstNameLocator = By.id("customer_firstname");
	private By lastNameLocator = By.id("customer_lastname");
	private By passwordLocator = By.id("passwd");
	private By addressLocator = By.id("address1");
	private By cityLocator = By.id("city"); 
	private By zipCodeLocator = By.id("postcode");
	private By phoneNumberLocator = By.id("phone_mobile");
	private By aliasEmailLocator = By.id("alias");
	private By registerButtonLocator = By.id("submitAccount");
	
	//Constructor
	public AccountCreationPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public void createNewAccount(
			String firstName,
			String lastName,
			String password,
			String address,
			String city,
			String zipCode,
			String phoneNumber,
			String aliasEmail) {
		typeFirstname(firstName);
		typeLastName(lastName);
		createPassword(password);
		createAddress(address);
		createCity(city);
		selectState();
		typeZipCode(zipCode);
		typePhoneNumber(phoneNumber);
		typeAliasEmail(aliasEmail);
	}
	public void typeFirstname(String firstname) {
		type(firstname, firstNameLocator, 3);
	}
	
	public void typeLastName(String lastName) {
		type(lastName, lastNameLocator, 3);
	}
	
	public void createPassword(String password) {
		type(password, passwordLocator, 3);
	}

	public void createAddress(String address) {
		type(address, addressLocator, 3);
	}
	
	public void createCity(String city) {
		type(city, cityLocator, 3);		
	}
	
	public void selectState() {
		Select stateDropdown = new Select(driver.findElement(By.id("id_state")));
		stateDropdown.selectByIndex(1);
	}
	
	public void typeZipCode(String zipCode) {
		type(zipCode, zipCodeLocator, 3);
	}
	
	public void typePhoneNumber(String phoneNumber) {
		type(phoneNumber, phoneNumberLocator, 3);
	}
	
	public void typeAliasEmail(String aliasEmail) {
		clear(aliasEmailLocator, 3);
		type(aliasEmail, aliasEmailLocator, 3);
	}
	
	public AddressPageObject clickRegisterButton() {
		click(registerButtonLocator, 3);
		return new AddressPageObject(driver);
	}
}
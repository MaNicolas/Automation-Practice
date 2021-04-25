package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPageObject extends HeaderPageObject{

	//Locators
	private By bankWireLocator = By.xpath("//a[@title='Pay by bank wire']");
	private By checkLocator = By.xpath("//a[@title='Pay by check.']");
	private By confirmOrderButtonLocator = By.xpath("//button[@class='button btn btn-default button-medium']");
	private By confirmationMessage = By.xpath("//*[text()='Your order on My Store is complete.']");
	
	//Constructor
	public PaymentPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public void payByBankWire() {
		click(bankWireLocator, 3);
	}
	
	public void payByCheck() {
		click(checkLocator, 3);
	}
	
	public void confirmOrder() {
		click(confirmOrderButtonLocator, 3);
	}
}
package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class PopupPageObject extends HeaderPageObject {

	// Variables
	private By confirmationMessageLocator = By.xpath("//i[@class='icon-ok']/following-sibling::text()[contains(., 'Product')]");
	private By quantityLocator = By.id("layer_cart_product_quantity");
	private By checkOutbuttonLocator = By.xpath("//a[@title='Proceed to checkout']");

	// Constructor
	public PopupPageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public CartPageObject clickCheckoutButton(){
		Reporter.log("Going to cart.");
		click(checkOutbuttonLocator, 3);
		return new CartPageObject(driver);
	}
	
	public String checkConfirmationMessage() {
		waitForVisibilityOf(confirmationMessageLocator, 5);
		System.out.println(find(confirmationMessageLocator).getText());
		return find(confirmationMessageLocator).getText();
	}
}
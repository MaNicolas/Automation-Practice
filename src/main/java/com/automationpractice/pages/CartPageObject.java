package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageObject extends HeaderPageObject{

	//Variable
	private String url = "http://automationpractice.com/index.php?controller=order";
	private float shippingCost = 2.0f;
	
	//Locators
	private By checkoutLocator = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']");
	private By quantityLocator = By.id("summary_products_quantity");
	private By totalPriceLocator = By.id("total_price");
	
	//Constructor
	public CartPageObject(WebDriver driver) {
		super(driver);
	}

	//Methods
	public LoginPageObject clickCheckoutButton() {
		click(checkoutLocator, 3);
		return new LoginPageObject(driver);
	}
	
	public String getUrl() {
		return url;
	}
	
	public int getTotalQuantity() {
		String text = find(quantityLocator).getText();
		int totalQuantity = Integer.valueOf(removeSpecialCharacters(text));
		return totalQuantity;
	}
	
	public float getShippingCost() {
		return shippingCost;
	}
	
	public float getTotalPrice() {
		String text = find(totalPriceLocator).getText();
		float totalPrice = Float.valueOf(removeSpecialCharacters(text));
		return totalPrice;
	}
}
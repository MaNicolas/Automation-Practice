package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPageObject extends HeaderPageObject {

	//private
	private float itemPrice;
	
	//Lcoators
	private By priceLocator = By.id("our_price_display");
	private By addToCartButtonLocator = By.id("add_to_cart");
	
	//Constructor
	public ItemPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public void readItemPrice() {
		String text = find(priceLocator).getText();
		text = removeSpecialCharacters(text);
		itemPrice = Float.valueOf(text);
	}
	
	public float getHatPrice() {
		return itemPrice;
	}
	
	public void clickAddToCart() {
		click(addToCartButtonLocator, 3);
	}
}
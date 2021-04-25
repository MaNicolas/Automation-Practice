package com.automationpractice.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPageObject extends HeaderPageObject {

	// Variables
	private float itemPrice;

	// Locators
	private By itemsLocator = By.xpath("//div[@class='right-block']");
	private By addToCartButtonLocator = By.xpath(".//a[@title='Add to cart']");
	private By priceItemLocator = By.xpath(".//span[@class='price product-price']");

	// Constructor
	public ResultsPageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public PopupPageObject selectRandomItemFromTheList() {
		//Get all items from the list
		List<WebElement> items = findAll(itemsLocator);

		//Select any item from the list
		Random random = new Random();
		int randomNumber = random.nextInt(items.size());
		WebElement randomItem = items.get(randomNumber);
		
		//Store its price for later assertion
		String text = randomItem.findElement(priceItemLocator).getText();		
		text = removeSpecialCharacters(text);
		itemPrice = Float.valueOf(text);
		
		//Hover over item to display "Add to cart button"
		hoverOverElement(randomItem);

		//Click "Add to cart button"
		randomItem.findElement(addToCartButtonLocator).click();
		
		return new PopupPageObject(driver);
	}
	
	public float getItemPrice() {
		return itemPrice;
	}
}

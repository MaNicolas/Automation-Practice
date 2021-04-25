package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HeaderPageObject extends BasePageObject{

	// Variables
	private By searchBar = By.id("search_query_top");
	private By searchButton = By.xpath("//button[@name='submit_search']");
	
	//Constructor
	public HeaderPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public ResultsPageObject searchForItem(String item) {
		Reporter.log("Searching for item: '" + item + "'.");
		type(item, searchBar, 3);
		click(searchButton, 3);
		return new ResultsPageObject(driver);
	}

}
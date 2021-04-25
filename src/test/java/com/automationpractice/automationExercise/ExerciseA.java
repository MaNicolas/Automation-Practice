package com.automationpractice.automationExercise;

import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationpractice.base.CsvDataProviders;
import com.automationpractice.base.TestUtilities;
import com.automationpractice.pages.AccountCreationPageObject;
import com.automationpractice.pages.AddressPageObject;
import com.automationpractice.pages.CartPageObject;
import com.automationpractice.pages.LoginPageObject;
import com.automationpractice.pages.PaymentPageObject;
import com.automationpractice.pages.PopupPageObject;
import com.automationpractice.pages.ResultsPageObject;
import com.automationpractice.pages.ShippingPageObject;
import com.automationpractice.pages.WelcomePageObject;

public class ExerciseA extends TestUtilities {

	@Test(invocationCount = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void purchaseItemWithNewAccount(Map<String, String> testData) {

		// Data
		String testNumber = testData.get("testNumber");
		String itemToPurchase = testData.get("itemToPurchase");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String password = testData.get("password");
		String address = testData.get("address");
		String city = testData.get("city");
		String zipCode = testData.get("zipCode");
		String phoneNumber = testData.get("phoneNumber");
		String aliasEmailAddress = testData.get("aliasEmailAddress");
		
		Reporter.log("Starting test #" + testNumber + " from CSV file.");
				
		// Go to page http://automationpractice.com/index.php
		WelcomePageObject welcomePage = new WelcomePageObject(driver);
		welcomePage.openPage();

		// Search for item
		ResultsPageObject resultsPage = welcomePage.searchForItem(itemToPurchase);

		// Select random item from the list
		PopupPageObject popupPage = resultsPage.selectRandomItemFromTheList();

		// Assert pop up is there
		//Assert.assertEquals(popupPage.checkConfirmationMessage(), "Product successfully added to your shopping cart");

		// Click "proceed to checkout" (go to cart)
		CartPageObject cartPage = popupPage.clickCheckoutButton();

		// In cart, assert total number of item and total price are correct
		// Check that url is "http://automationpractice.com/index.php?controller=order"
		Reporter.log("Checking if total number of item and total price are correct in cart");
		Assert.assertEquals(cartPage.readUrl(), cartPage.getUrl());
		
		Assert.assertEquals(cartPage.getTotalQuantity(), 1);
		Reporter.log("There is " + cartPage.getTotalQuantity() + " item in cart.");
		
		Assert.assertEquals(cartPage.getTotalPrice(), cartPage.getShippingCost() + resultsPage.getItemPrice());
		Reporter.log("Total price with shiping is $" + cartPage.getTotalPrice() + ".");
		
		Reporter.log("Total number of item and total price are correct!");
		
		// Click proceed to checkout
		LoginPageObject loginPage = cartPage.clickCheckoutButton();

		// Generate random email address and click "Create an account" button
		AccountCreationPageObject accountCreationPage = loginPage.createAnAccount(randomEmail());
		
		// Create new account
		accountCreationPage.createNewAccount(
				firstName,
				lastName,
				password,
				address,
				city,
				zipCode,
				phoneNumber,
				aliasEmailAddress);
		AddressPageObject addressPage = accountCreationPage.clickRegisterButton();
		
		// Checking user's information are correct
		ShippingPageObject shippingPage = addressPage.clickCheckoutButton();
		
		// Tick "Terms of service" checkBox if necessary and click checkout button
		shippingPage.selectCheckBox();
		PaymentPageObject paymentPage = shippingPage.clickCheckoutButton();
		
		// Click on "Pay by bank wire"
		paymentPage.payByBankWire();
		
		// Confirm order
		paymentPage.confirmOrder();		
	}
}
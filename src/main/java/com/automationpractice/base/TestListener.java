package com.automationpractice.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

	// Variables
	String testName;
	String testMethodName;

	// Methods
	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		Reporter.log("[Starting '" + testMethodName + "' test]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[RESULT: '" + testMethodName + "' has successfully passed.]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("[RESULT: '" + testMethodName + "' has failed. Taking screenshot!]");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		Reporter.log("[TEST '" + testName + "' STARTED]");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("[ALL '" + testName + "' FINISHED]");
	}
}
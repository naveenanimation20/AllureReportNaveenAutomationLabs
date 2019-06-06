package com.qa.hubspot.tests;

import org.testng.TestNG;

import com.qa.hubspot.listeners.ExtentReportListener;

public class TestRunner {
	
	static TestNG testNg;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ExtentReportListener ext = new ExtentReportListener();

		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {LoginTest.class});
		testNg.addListener(ext);
		testNg.run();
		
		
	}

}

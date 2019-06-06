package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class LoginTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;

	// test classes : --> test methods -- test cases

	// test case 1:
	// pre condition: open browser, url,
	// test steps -- test case : loginTest -- un/pwd/loginbtn
	// validations -- ac vs exp
	// post step: close the browser

	// test case 2:
	// pre condition: open browser, url,
	// test steps -- test case : check signup link on the page
	// validations -- ac vs exp
	// post step: close the browser

	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("the login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2, description = "verifying sign up link test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify verify SignUp Link Test on Login Page")
	@Story("Story Name: To check sign up link")
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.VerifySignUpLink());
	}

	@Test(priority = 3, description = "login into app test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: verify login into application with correct credentials")
	@Story("Story Name: To check login functionality")
	public void loginCorrectCredentialsTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}

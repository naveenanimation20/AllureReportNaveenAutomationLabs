package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

import con.qa.hubspot.util.TestUtil;

public class ContactsPageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;

	@BeforeMethod // this method will be executed before every @test method
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.navigateToContactsPage();
	}

	@DataProvider(name = "getContactsTestData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = TestUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return contactsData;
	}
	
	

	@Test(dataProvider = "getContactsTestData")
	public void createNewContactTest(String email, String firstName, String lastName, String jobTitle) {
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
		
	}

	@AfterMethod // --this method will be executed after every test method
	public void tearDown() {
		driver.quit();
	}

}

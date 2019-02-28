package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	
	@BeforeMethod //this method will be executed before every @test method
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("the home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	
	@Test
	public void verifyHomePageHeaderTest(){
		Assert.assertTrue(homePage.verifyHomePageHeader());
		
		String homePageHeader = homePage.getHomePageHeaderText();
		System.out.println("home page header is: "+ homePageHeader);
		Assert.assertEquals(homePageHeader, Constants.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verifyContactsLinkTest(){
		homePage.navigateToContactsPage();
	}
	
	@Test(enabled=false)
	public void verifyDealsLinkTest(){
		Assert.assertEquals(true, false);
	}
	
	
	@AfterMethod //--this method will be executed after every test method
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}

package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.Base.BasePage;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	//1.a: define page objects (PAGE OR) : using PageFactory Pattern
	
	@FindBy(id = "username")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText = "Sign up")
	WebElement signUpLink;
	
	//1.b: Constructor of page class and initialize elements with driver
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//2. Page methods - Actions:
	@Step("getting login page title step....")
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	@Step("verifying sign up link is displayed step....")
	public boolean VerifySignUpLink(){
		return signUpLink.isDisplayed();
	}
	
	@Step("login with username: {0} and password: {1} step...")
	public HomePage login(String un, String pwd){
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver);
	}
	

}

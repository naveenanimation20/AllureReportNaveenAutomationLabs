package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;


public class ContactsPage extends BasePage{
	
	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactBtn;
	
	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondBtn;
	
	@FindBy(id = "uid-ctrl-1")
	WebElement email;
	
	@FindBy(id = "uid-ctrl-2")
	WebElement firstName;
	
	@FindBy(id = "uid-ctrl-3")
	WebElement lastName;
	
	@FindBy(id = "uid-ctrl-5")
	WebElement jobTitle;
	
	
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String emailVal, String firstname, String lastname, String jobtitle ){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		createContactBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailVal);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		createContactSecondBtn.click();
		
	}
	

}

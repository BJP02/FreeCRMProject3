package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.base.TestBase;

public class HomePage extends TestBase {
 
	WebElement UserDisplay;
	WebElement Contacts;
	WebElement Deals;
	WebElement Tasks;
	WebElement New;
	
	
	public HomePage() {
		//Initializing the page objects
	UserDisplay = driver.findElement(By.xpath("//span[contains(text(),'Bhumika Parikh')]"));
	Contacts = driver.findElement(By.xpath("//span[contains(text(),'Contacts')]"));
	Deals = driver.findElement(By.xpath("//span[contains(text(),'Deals')]"));
	Tasks = driver.findElement(By.xpath("//span[contains(text(),'Tasks')]"));
	
	
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserDisplay() {
		return UserDisplay.isDisplayed();
		
	}
	
	public ContactsPage ClickOnContactsLink() {
		Contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink() {
		Deals.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink() {
		Tasks.click();
		return new TasksPage();	
	}

	
}
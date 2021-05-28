package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase {


	WebElement Contacts;
	WebElement New;
	WebElement FirstName;
	WebElement LastName;
	WebElement MiddleName;
	WebElement Company;
	WebElement Save;
	
	
	public ContactsPage() {
//Initialization 
		
 Contacts = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"))	;	
			
	}
//validation of Contact page
	public boolean ValidateContactsLabel(){
	 return Contacts.isDisplayed();
	}
	
	public String ValidateContactString(){
		 return Contacts.getText();
	}
	
	public void CreateNewContacts(String ftName,String ltName,String mlName,String company) {
		New = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']//a[@href='/contacts/new']/button"));
		New.click();
		FirstName =	driver.findElement(By.xpath("//div[@id='main-content']/div/div[2]/form//input[@name='first_name']"));  	
		LastName=  driver.findElement(By.xpath("//div[@id='main-content']/div/div[2]/form//input[@name='last_name']"));
		MiddleName =driver.findElement(By.xpath("//div[@id='main-content']/div/div[2]/form//input[@name='middle_name']"));
		Company = driver.findElement(By.xpath("//div[@id='main-content']/div/div[2]/form/div[2]/div[2]/div/div[@role='combobox']/input"));	
		Save = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[2]/div/button[2]"));	
    

                FirstName.sendKeys(ftName);
	            LastName.sendKeys(ltName);
	            MiddleName.sendKeys(mlName);
	            Company .sendKeys(company);
	            Save.click();
	}
	
}

	
	
	
	
	
	
	
	


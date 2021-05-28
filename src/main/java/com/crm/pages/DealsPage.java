package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class DealsPage extends TestBase{

	WebElement Deals;
	WebElement New;
	WebElement Title;
	WebElement Access;
	WebElement Assigned;
	WebElement Products;
	WebElement Company;
	WebElement Date;
	WebElement Nextlink;
	WebElement Save;	
//Initialization	
	
	public DealsPage() {
		
		 Deals = driver.findElement(By.xpath("//span[contains(text(),'Deals')]"))	;
	}
	
//Validation of Deals Page 
	public boolean ValidateDealsLabel(){
		 return Deals.isDisplayed();
		}
	
	public String ValidateDealsString(){
		 return Deals.getText();
	}
	
	public void CreateNewDeals(String title,String assign,String products,String company, String day) throws InterruptedException {
//To click on new button:
	New = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[3]/button[1]"));
	New.click();
	
	Title =	driver.findElement(By.name("title"));
	Title.sendKeys(title);
		
/*	Access = driver.findElement(By.xpath("//button[@innertext='Public']/i[@safeclass~'\\bicon\\b.*\\bunlock\\b']"));
	Access.click();*/
	

//assigned Value
	Assigned = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]")); 
	Assigned.sendKeys(assign);
    
		
	//Products = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]"));
	//Products.sendKeys(products);
    
	Company = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));	
	Company .sendKeys(company);
	
	Date = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/input[1]"));	
	Date.click();
	
	Thread.sleep(1000);
	  Nextlink = driver.findElement(By.xpath("//button[contains(text(),'Next Month')]"));
	  Nextlink.click();

// This method will select the date dynamically .
			
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[contains(text(),"+day+")]")).click();
		//
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]")).click();
					
		Save = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]"));
            
 
 
 
 			
            Save.click();
	}
}

package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.base.TestBase;



public class LoginPage extends TestBase {

	// Define Page Factory or object repository of login page ( page object model framework)
	/*	@FindBy(name ="email")
		WebElement Email;
		
		@FindBy(name = "password")
		WebElement Password;
		
		@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
		WebElement Login;
		
		@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[3]/a")
		WebElement SignUp;
	
	//Initializing the page objects through page model approach		
		public LoginPage() {
			PageFactory.initElements(driver,this);
		}*/
		
	//Global Erp way of doing(Created objects for login page)
		WebElement Email;
		WebElement Password;
		WebElement LoginButton;
		WebElement SignUp;
		
		public LoginPage() {
			//Initializing the page objects
		Email = driver.findElement(By.name("email"));
		Password = driver.findElement(By.name("password"));
		LoginButton = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]"));
		SignUp = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
		}
		
	//Validation of LoginPage Title 	
		public String ValidateLoginPageTitle(){
			return driver.getTitle();
		}
		
	//validation of Any Image on LoginPage
		//public boolean validateCRMImage() {
			// return crmlogo.isDisplayed();
		//}
		
	// This method is for,When login button is clicked it lands you on HomePage (LandingPage)
		public HomePage login(String email,String pwd) {
			Email.sendKeys(email);
			Password.sendKeys(pwd);
			LoginButton.click();
			return new HomePage();
			
		}
		
		public String ValidateHomePageTitle() {
			return HomePage.driver.getTitle();
		}
		
		
		
		
		
		
		
	}



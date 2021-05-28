package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;



public class LoginPagetest extends TestBase{
	
	LoginPage lp;//defining variable for LoginPage objectReference
	HomePage hp;
	
	public LoginPagetest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		 lp = new LoginPage();// Created objectReference
	}
	
	
	@Test(priority=1)
	public void LoginTest() {
		hp = lp.login(prop.getProperty("email"),prop.getProperty("pwd"));		
		String Hptitle = lp.ValidateHomePageTitle();
		
		System.out.println(Hptitle);
		Assert.assertEquals(Hptitle,"Cogmento CRM");
	}
	   
	
	@Test(priority=2)
	public void LoginPageTitletest() {
		String title = lp.ValidateLoginPageTitle();
		System.out.println(title);
	Assert.assertEquals(title,"Cogmento CRM");
	}
	
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
	
	
	
	
	
	
	
	
	
	



package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;


public class DealsPageTest extends TestBase {

	  LoginPage lp;
	     HomePage hp;
		TestUtil tu;     //created when your userdisplay is in frame 
	   // ContactsPage cp;
	     DealsPage dp;
	     
	     public DealsPageTest() {
			super();
		}
	
	     @BeforeMethod
	 	public void setup(){
	 		initialization();
	 			        	
	 		lp = new LoginPage();// Created objectReference
	 		hp= lp.login(prop.getProperty("email"),prop.getProperty("pwd"));
	  	}
	
	@Test (priority = 1)
		
		public void ValidateDealsLabel() {
			dp = hp.ClickOnDealsLink();
		    String DealsLabel = dp.ValidateDealsString();
			System.out.println(DealsLabel);
			Assert.assertEquals(DealsLabel,"Deals");
			
	}
	
	@DataProvider
	
		public Object[][] getCRMTestData() throws Throwable{
			Object data[][] = TestUtil.getTestData("Deals");
			return data;
		}
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	
	public void ValidateCreateNewDeals(String title,String assign,String products,String company, String day) throws InterruptedException {
		dp = hp.ClickOnDealsLink();
		dp.CreateNewDeals(title,assign,products,company,day);
	}	
	
	@AfterMethod
	     public void tearDown() {
	    	driver.quit();
	}
}	     
	
	
	
	
	


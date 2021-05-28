package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;


public class ContactsPageTest extends TestBase  {

	  LoginPage lp;
	     HomePage hp;
//		TestUtil tu;     //created when your userdisplay is in frame 
	    ContactsPage cp;
	     
	     
	     public ContactsPageTest() {
			super();
		}
	
	     @BeforeMethod
	 	public void setup(){
	 		initialization();
	 		        	
	 		lp = new LoginPage();// Created objectReference
	 		hp= lp.login(prop.getProperty("email"),prop.getProperty("pwd"));
	 		
	 		
	 	}
	
	@Test (priority = 1)
		
		public void ValidateContactsLabel() {
			cp = hp.ClickOnContactsLink();
		    String ContactLabel = cp.ValidateContactString();
			System.out.println(ContactLabel);
			Assert.assertEquals(ContactLabel,"Contacts");
			
	}
	
	@DataProvider
	
		public Object[][] getCRMTestData() throws Throwable{
			Object data[][] = TestUtil.getTestData("Contacts");
			return data;
		}
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	
	public void ValidateCreateNewContact(String ftName,String ltName,String mlName,String company) {
		cp = hp.ClickOnContactsLink();
		cp.CreateNewContacts(ftName, ltName, mlName, company);
	}	
	
	@AfterMethod
	     public void tearDown() {
	    //	 driver.quit();
}
}


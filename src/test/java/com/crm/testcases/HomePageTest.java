package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;


public class HomePageTest extends TestBase {

	   LoginPage lp;
	     HomePage hp;
//		TestUtil tu;     //created when your userdisplay is in frame 
	    ContactsPage cp;
	     
	     
	     public HomePageTest() {
			super();
		}
		
		@BeforeMethod
		public void setup(){
			initialization();
		//	tu= new TestUtil();
		
			lp = new LoginPage();// Created objectReference
			hp= lp.login(prop.getProperty("email"),prop.getProperty("pwd"));
			
			
		}
		
		@Test(priority=1 )
		 public void verifyHomePageTitleTest() {
			String HomePageTitle = hp.VerifyHomePageTitle();
			Assert.assertEquals(HomePageTitle, "Cogmento CRM","Home page Title not matched");
		 }
		 @Test(priority=2)
		 public void verifyUserDisplayTest() {
			//tu.switchToframe();//When your UserDisplay is in frame
			 Assert.assertTrue(hp.verifyCorrectUserDisplay());
		 }
		
			@Test (priority=3)
		public void verifyContactsLinkTest() {
		//	tu.switchToFrame();
			cp = hp.ClickOnContactsLink();
			boolean Label = cp.ValidateContactsLabel();
			System.out.println(Label);
			Assert.assertEquals(Label,true,"Label not displayed");
			
		}
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
	}

	


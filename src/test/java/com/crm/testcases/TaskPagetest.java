package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.TasksPage;
import com.crm.util.TestUtil;


public class TaskPagetest extends TestBase {

	  LoginPage lp;
	     HomePage hp;
//		TestUtil tu;     //created when your userdisplay is in frame 
	   // ContactsPage cp;
	     TasksPage tp;
	     
	     
	     
	     public TaskPagetest() {
			super();
		}
	
	     @BeforeMethod
	 	public void setup(){
	 		initialization();
	 		        	
	 		lp = new LoginPage();// Created objectReference
	 		hp= lp.login(prop.getProperty("email"),prop.getProperty("pwd"));
	 		
	 		
	 	}
	
	@Test (priority = 1)
		
		public void ValidateTasksLabel() {
			tp = hp.ClickOnTasksLink();
		    String TasksLabel = tp.ValidateTasksString();
			System.out.println(TasksLabel);
			Assert.assertEquals(TasksLabel,"Tasks");
			
	}
	
	@DataProvider
	
		public Object[][] getCRMTestData() throws Throwable{
			Object data[][] = TestUtil.getTestData("Tasks");
			return data;
		}
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	
	public void ValidateCreateNewTasks(String title,String assign,String deals,String day,String type) throws InterruptedException  {
		tp = hp.ClickOnTasksLink();
		tp.CreateNewTasks(title,assign,deals,day,type);
	}	
	
	@AfterMethod
	     public void tearDown() {
	    	// driver.quit();
}
}	     


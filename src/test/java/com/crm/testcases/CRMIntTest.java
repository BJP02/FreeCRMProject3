package com.crm.testcases;

import org.testng.annotations.BeforeMethod;

import com.crm.base.TestBase;
import com.crm.pages.LoginPage;
import com.crm.testcases.*;

public class CRMIntTest extends TestBase {


	public CRMIntTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		new LoginPagetest();// Created objectReference
		 
		
	}
	
}

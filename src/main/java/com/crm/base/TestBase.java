package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;



public class TestBase {

	public static	WebDriver driver;
    public static Properties prop ;
    public static EventFiringWebDriver edriver;
    public static WebEventListener eventlistener;
    
	public TestBase() {
		try {
		prop =new Properties();
	FileInputStream ip = new FileInputStream("C:\\eclipsephoton-workspace\\FreeCRMProject\\src\\main\\java\\com\\crm\\config\\Config.Properties");		
				prop.load(ip);
	
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}	
}	
		public static void initialization() {
			String browserName = prop.getProperty("browser");
		
			if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\eclipsephoton-workspace\\FreeCRMProject\\chromedriver.exe");
			 driver=new ChromeDriver();
		}	
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "geckodriverpath");	
			driver = new FirefoxDriver(); 
		}

			edriver = new EventFiringWebDriver(driver);
			eventlistener = new WebEventListener();
			edriver.register(eventlistener);
			driver = edriver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}			
}
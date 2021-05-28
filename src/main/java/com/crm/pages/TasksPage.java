package com.crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.crm.base.TestBase;

public class TasksPage extends TestBase {
	
	WebElement Tasks;
	WebElement New; //New means New Button on Tasks page
	WebElement Title;
	WebElement Assigned;
	WebElement Date;
	WebElement Nextlink;
	WebElement Save;
	WebElement Deals;
	WebElement TypeList;
	
	public TasksPage() {
//Initialization of Tasks Page 
				
		 Tasks = driver.findElement(By.xpath("//span[contains(text(),'Tasks')]"))	;//path to click on Tasks	
	}

//validation of Task page
		public boolean ValidateTasksLabel(){
		 return Tasks.isDisplayed();
		}
	
		public String ValidateTasksString(){
			 return Tasks.getText();
		}	
	
	public void CreateNewTasks(String title,String assign,String deals,String day,String type) throws InterruptedException {
	
	New = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]"));	
	New.click();
	
	Title = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
	Title.sendKeys(title);
	
	Assigned = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]"));
	Assigned.sendKeys(assign);
	
	Date = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"));
	Date.click();
	
	Thread.sleep(1000);
	  Nextlink = driver.findElement(By.xpath("//button[contains(text(),'Next Month')]"));
	  Nextlink.click(); // date next month link
	  
//Date And Time selection	  
	  driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[contains(text(),"+day+")]")).click();
	
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]")).click();
					
  Deals = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/input[1]"));
  Deals.click();

 //Deals dropdown  
    
    WebElement fromDropDwon = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/input[1]"));
	fromDropDwon.click();
	fromDropDwon.sendKeys(deals);
	Thread.sleep(1000);
	fromDropDwon.sendKeys(Keys.ARROW_DOWN +""+ Keys.ENTER);

//Type Dropdown
	
	WebElement fromDropDownType = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
	fromDropDownType.click();

	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div["+ type +"]")).click();
	
	//span[contains(text(),'Business Support')]
	

   Save = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]/i[1]"));
   Save.click(); 
	}
}
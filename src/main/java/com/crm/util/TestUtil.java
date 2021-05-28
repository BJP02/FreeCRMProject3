package com.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.base.TestBase;

public class TestUtil extends TestBase {

	

	public static long IMPLICIT_WAIT =10;
	public static long PAGE_LOAD_TIMEOUT=20;
	
	//Create this method if your UserDisplay is in frame
	/*	public void switchToFrame() {
			driver.switchTo().frame("mainpanel");
		}*/

		public static String TESTDATA_SHEET_PATH = "C:\\eclipsephoton-workspace\\FreeCRMProject\\src\\main\\java\\com\\crm\\testdata\\CRMData.xlsx";

		static Workbook book;
		static Sheet sheet;
		static JavascriptExecutor js;

		public static Object[][] getTestData(String sheetName) throws Throwable {
			FileInputStream file = null;
				file = new FileInputStream(TESTDATA_SHEET_PATH);
				book = WorkbookFactory.create(file);

			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println(data[i][k]);
				}
			}
			return data;
		}

		public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir +"/screenshots/"+ System.currentTimeMillis() + ".png"));
		//System.out.println("Test");
	}





	}





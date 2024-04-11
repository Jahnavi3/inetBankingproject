package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
//This is a DATA DRIVEN TESTCASE
//This Class needs all other classes we created except "TC_LoginTest_001" class
public class TC_LoginDDT_002 extends Baseclass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws IOException { // As Dataprovider returns 2D ARRAY  which contains username and password
		//This method is executed multiple times based on the inputs
		LoginPage lp =new LoginPage(driver);
		lp.setUsername(user);
		log.info("Username is Entered");
		lp.setPwd(pwd);
		log.info("Password is Entered");
		lp.clickLogin();
		log.info("Login is clicked");
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login is Failed");
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			log.info("Logout is clicked");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login is Passed");
			
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		//Path of Xls file
		String path = System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		//String path = "C:\\Users\\Deepika\\eclipse-workspace\\inetBanking\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"sheet1");// in xl file, sheet1
		int colcount = XLUtils.getCellCount(path,"sheet1",1);
		
		String logindata[][] = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j] = XLUtils.getCellData(path,"sheet1",i,j); //in xls - i,j is equal to 2d array - i-1,j
				
			}
		}
		return logindata;
	
	}

}

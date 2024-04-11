package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

//IF WE WANT TO RUN ONLY FAILED TESTCASES THEN IN "test-output", run "testng-failed.xml"

public class TC_LoginTest_001 extends Baseclass {
	@Test
	public void loginTest() throws IOException {
		//driver.get(baseUrl);
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		log.info("url is opened");
		lp.setUsername(username);
		log.info("Username is entered");
		lp.setPwd(password);
		log.info("Password is entered");
		lp.clickLogin();
		log.info("Login is clicked");
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
//		if (w.until(ExpectedConditions.alertIsPresent()) != null) {
//			driver.switchTo().alert().accept();
//			captureScreen(driver,"loginTest");// we r calling method in base class to take screenshot
//			log.error("Login testcase FAILED");
//			Assert.assertTrue(false);
//		
//		} else if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//
//				Assert.assertTrue(true);
//				log.info("Login testcase passed");
//			} else {
//				captureScreen(driver, "loginTest");// we r calling method in base class to take screenshot
//				log.error("Login testcase FAILED");
//				Assert.assertTrue(false);
//
//			}
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login is Failed");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			//lp.clickLogout();
			//log.info("Logout is clicked");
			//driver.switchTo().alert().accept();
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
	

}

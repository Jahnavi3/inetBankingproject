package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends Baseclass {
	
	@Test
	public void addNewCustomer() throws IOException {
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		log.info("url is opened");
		lp.setUsername(username);
		log.info("Username is entered");
		lp.setPwd(password);
		log.info("Password is entered");
		lp.clickLogin();
		log.info("Login is clicked");
		
		AddCustomerPage ac = new AddCustomerPage(driver);
		log.info("Providing customer details");
		ac.clickAddCustomer();
		log.info("Add Customer is clicked");
		ac.setName("Jahnavi");
		log.info("name is entered");
		ac.setGender("female");
		ac.setDob("03", "03", "2003");
		ac.setAddress("Hyd");
		ac.setCity("Hyd");
		ac.setState("telanagana");
		ac.setPin("500032");
		ac.setTel("9876543210");
		String email = randomString()+"@"+randomString2()+".com"; //for generating random emails
		ac.setEmail(email);
		ac.setPwd("Abc123");
		ac.clickSubmit();
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
//		if (w.until(ExpectedConditions.alertIsPresent()) != null) {
//			driver.switchTo().alert().accept();
//			captureScreen(driver,"addNewCustomer");// we r calling method in base class to take screenshot
//			log.error("Login testcase FAILED");
//			Assert.assertTrue(false);
//
//		} else
		if (result==true) {
				Assert.assertTrue(true);
				log.info("Customer Registration is passed");
			} else {
				
				captureScreen(driver,"addNewCustomer");// we r calling method in base class to take screenshot
				log.error("Customer Registration is FAILED");
				Assert.assertTrue(false);

			}
		
	}
	//We can keep below methods in BASECLASS so that other testcases can also use
//	public String randomString() {
//		return RandomStringUtils.randomAlphabetic(8); // generated 8 letter random word
//	}
//	public String randomString2() {
//		return RandomStringUtils.randomAlphabetic(5);// generated 5 letter random word
//	}
	

}

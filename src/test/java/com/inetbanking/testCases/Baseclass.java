package com.inetbanking.testCases;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

// Baseclass - we created this inorder to avoid repetition of start and end methods

public class Baseclass {
	
	ReadConfig r= new ReadConfig();
	
	public String baseUrl = r.getAppUrl();
	public String username = r.getUsername();
	public String password = r.getPwd();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("browser")// to run in desired browser, these parameters are sent from testng.xml
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver();
			}
		else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			}
		driver.get(baseUrl);// here we r opening the browser instead of in normal login test case becoz if we open here ,
		//it is applicable to both NORMAL testcase and DATA DRIVEN testcase
		// otherwise we have to write same code line in  both NORMAL testcase and DATA DRIVEN testcase
		
		
		log = LogManager.getLogger(Baseclass.class);//log4j2 syntax For logs to generate 
	//add log4j2.properties files in resources and after if we run testcases ,
		//logs folder will be automatically created and logs will be stored in logs file
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//This class is to  take screenshot and store it in Screenshots folder
	// This method is called in Testcase TC_Login001 in fail cases
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		//System.getProperty("user.dir") - this gives project home directory location, and after that use forward slashes "/"
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(8); // generated 8 letter random word
	}
	public String randomString2() {
		return RandomStringUtils.randomAlphabetic(5);// generated 5 letter random word
	}
	
}

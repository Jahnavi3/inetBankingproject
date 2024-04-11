package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement uname;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbtn;
	
	//For Data driven testcase
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutbtn;
	
	public void setUsername(String user) {
		uname.sendKeys(user);
	}
	
	public void setPwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}
	
	//FOR DATA DRIVEN TESTCASE
	public void clickLogout() {
		logoutbtn.click();
	}
	
}

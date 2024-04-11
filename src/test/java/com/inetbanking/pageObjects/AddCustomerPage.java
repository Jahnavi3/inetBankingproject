package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement addcustomer;
	
	@FindBy (name ="name")
	@CacheLookup
	WebElement name;
	
	@FindBy (name ="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy (name ="dob")
	@CacheLookup
	WebElement dob;
	
	@FindBy (name ="addr")
	@CacheLookup
	WebElement addr;
	
	@FindBy (name ="city")
	@CacheLookup
	WebElement city;
	
	@FindBy (name ="state")
	@CacheLookup
	WebElement state;
	
	@FindBy (name ="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy (name ="telephoneno")
	@CacheLookup
	WebElement tel;
	
	@FindBy (name ="emailid")
	@CacheLookup
	WebElement email;
	
	@FindBy (name ="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name ="sub")
	@CacheLookup
	WebElement submit;
	
	@FindBy(name ="res")
	@CacheLookup
	WebElement reset;
	
	public void clickAddCustomer() {
		addcustomer.click();
	}
	
	private void waitforPopup() throws Error{
		if(driver.getPageSource().contains("iframe")==true) {
			WebElement ad = driver.findElement(By.id("gpt_unit_/24132379/INTERSTITIAL_DemoGuru99_0"));
			driver.switchTo().frame(ad);
			
			WebElement ad1 = driver.findElement(By.id("ad_iframe"));
			driver.switchTo().frame(ad1);
			
			driver.findElement(By.id("dismiss-button")).click();
			driver.switchTo().defaultContent();
		}
	}
	public void setName(String uname) {
		waitforPopup();
		name.sendKeys(uname);
	}
	
	public void setGender(String gen) {
		gender.sendKeys(gen);
	}
	
	public void setDob(String dd,String mm, String yyyy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	
	public void setAddress(String add) {
		addr.sendKeys(add);
		
	}
	
	public void setCity(String c) {
		city.sendKeys(c);
		
	}
	
	public void setState(String s) {
		state.sendKeys(s);
		
	}
	
	public void setPin(String pincode) {
		pin.sendKeys(String.valueOf(pincode));
		
	}
	
	public void setTel(String phnno) {
		tel.sendKeys(phnno);
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
				
	}
	
	public void setPwd(String pass) {
		pwd.sendKeys(pass);
		
	}
	
	public void clickSubmit() {
		submit.click();
		
	}
	
	public void clickReset() {
		reset.click();
		
	}

}

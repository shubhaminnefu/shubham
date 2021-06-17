package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class Login {

	public WebDriver driver;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	@CacheLookup
	WebElement txtuname;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(xpath ="//*[@id=\"login_panel\"]/div[3]/div/div/button")
	@CacheLookup
	WebElement submit_btn;
	
	@FindBy(id="err_user_name")
	@CacheLookup
	WebElement errorusername;
	
	@FindBy(id="err_password")
	@CacheLookup
	WebElement errorpwd;

	public void logintest(String username,String password) {
		txtuname.sendKeys(username);
		
		txtpwd.sendKeys(password);
		
		
	}
	
	public void submit() {
		submit_btn.click();
		
	}
	
	public void clearallvalues() {
		txtuname.clear();
		txtpwd.clear();
		
	}
}

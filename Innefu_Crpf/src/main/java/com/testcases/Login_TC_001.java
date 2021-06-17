package com.testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObject.Login;


@Listeners(com.utilities.Reporter.class)
public class Login_TC_001 extends BaseClass{
	String sheetName="Login";
	public WebElement element;
	
	@Test(dataProvider ="getLogindata")
	public void Logintestcases(String Username,String Password) throws Exception {
		Login login=new Login(driver);
		log.info("Username and password entered");
		login.logintest(Username, Password);
		login.submit();
		
		log.info("Submit button clicked");
		Thread.sleep(5000);
		
		String actualUrl="http://server2.authshieldserver.com:8080/icascrpf_latest/dashboard/";
		String expectedUrl= driver.getCurrentUrl();
		if(actualUrl.equalsIgnoreCase(expectedUrl)){
			System.out.println("user login successfully");
			driver.quit();
		}else {
		
	     login.clearallvalues();
	     System.out.println("value is cleared");
		
		}
		
		
		
		BaseClass br=new BaseClass();
		
		element=driver.findElement(By.id("err_user_name"));
		br.capturescreenshots(driver,"username error page");
		if(element.getText().equals(con.Getblank_username())) {
			System.out.println("User name is required.");
			
		}else if (element.getText().equals(con.Getinvalid_username())) {
			br.capturescreenshots(driver, "Incorrect username");
			System.out.println("Incorrect username.");
		} else
			System.out.println("username is correct");
		
		
		element=driver.findElement(By.id("err_password"));
		br.capturescreenshots(driver,"password error page");
		if(element.getText().equalsIgnoreCase(con.Getblank_password())) {
			System.out.println("Password is required");
			
		}else if(element.getText().equalsIgnoreCase(con.Getinvalid_password())) {
			br.capturescreenshots(driver, "Incorrect Password");
			System.out.println("Incorrect Password");
		}
		 else
				System.out.println("Password is correct");
		
	}
	@DataProvider
	public Object[][] getLogindata(){
		
		Object data[][]=com.testcases.DataProvider.GetTestData(sheetName);
		
		return data;
		
	}

}

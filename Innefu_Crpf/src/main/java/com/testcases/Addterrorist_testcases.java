package com.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObject.Add_Terrorist;
import com.PageObject.Login;

public class Addterrorist_testcases extends BaseClass{
	String sheetName="Terrorist";
	public WebElement element;
	@Test(dataProvider ="getterroristdata")
	public void addterrorist(String TerroristName,String Fathername) throws Exception {
		Login login=new Login(driver);
		log.info("Login data");
		login.logintest("Shubham unit","india@11");
		log.info("Login successfully");
		login.submit();
		
		Thread.sleep(4000);
		
		Add_Terrorist terror=new Add_Terrorist(driver);
		terror.addterroristdata(TerroristName,Fathername);
	}

	@DataProvider
	public Object[][] getterroristdata(){
		
		Object data[][]=com.testcases.DataProvider.GetTestData(sheetName);
		
		return data;
		
	}
}

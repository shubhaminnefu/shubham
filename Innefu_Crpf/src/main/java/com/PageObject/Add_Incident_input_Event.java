package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.testcases.BaseClass;

public class Add_Incident_input_Event {
	
	public WebDriver driver;
	
	
	public Add_Incident_input_Event(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"search_main-menu\"]")
	WebElement Incident_intelligence_menu;
	
	@FindBy(xpath ="//*[@id=\"sidebar\"]/nav/div/ul/li[3]/div/ul/li[1]")
    WebElement Incident_intelligence_input;
	
	
	@FindBy(xpath="//*[@id=\"removeUl\"]/li/a[2]")
	WebElement Add_Incident;
	
	
	public void menu() {
		Incident_intelligence_menu.click();
		Incident_intelligence_input.click();
	}
	
	
	
}

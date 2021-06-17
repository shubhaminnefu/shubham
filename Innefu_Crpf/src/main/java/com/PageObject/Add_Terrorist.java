package com.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class Add_Terrorist {

	public WebDriver driver;

	public Add_Terrorist(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Terrorist/Suspect")
	WebElement personmainmenu;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/nav/div/ul/li[7]/div/ul/li[1]/a")
	WebElement terrorist_screen_menu;

	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[1]/div[1]/header/nav/div/ul[2]/li/a[1]")
	WebElement Add_terrorist;

	@FindBy(name = "person[category]")
	WebElement Category;
	
	@FindBy(name="person[name]")
	WebElement name;
	
	@FindBy(name="person[fathername]")
	WebElement fname;

	public void addterroristdata(String tname,String fathername) throws Exception {
		personmainmenu.click();
		terrorist_screen_menu.click();
		Add_terrorist.click();
		Thread.sleep(4000);
		Select select = new Select(Category);
		List<WebElement> obj = select.getOptions();
		int size = obj.size();
		for (int i = 0; i < size; i++) {
			System.out.println(obj.get(i).getText());

		}
		select.selectByVisibleText("Criminal");
		
		name.sendKeys(tname);
		fname.sendKeys(fathername);

	}

}

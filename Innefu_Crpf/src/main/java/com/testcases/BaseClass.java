package com.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	
	public Logger log;

	ReadConfig con = new ReadConfig();
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception {
		
		log=Logger.getLogger("CRPF");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", con.Getchromepath());
			driver = new ChromeDriver();

		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", con.Getchromepath());
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		driver.get(con.GetApplicationURL());
		log.info("URL opened");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
	}
	
	public void capturescreenshots(WebDriver driver,String tname) throws Exception {

		File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Time-Report-"+timestamp+".png";
		File Target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+repName);
		FileUtils.copyFile(screenshotfile, Target);
		System.err.println("Screenshot taken");
	}

}

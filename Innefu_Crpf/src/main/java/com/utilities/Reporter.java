package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporter extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Time-Report-"+timestamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extent=new ExtentReports();
		
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name","localhost");
		 extent.setSystemInfo("Environment","QA");
		 extent.setSystemInfo("user","Shubham");
		 
		 htmlReporter.config().setDocumentTitle("Extent Report for ICAS Project");//Title Report
	     htmlReporter.config().setReportName("Test Report");//name of the report
	     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
	     htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	

	
	 public void onTestSuccess(ITestResult tr) {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	 
	 public void onTestFailure(ITestResult tr)  {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		 
		 String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		 
		 File f=new File(screenshotpath);
		 if(f.exists()) {
			 try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				e.printStackTrace();
			} } }
	 
	 
	 public void onTestSkipped(ITestResult tr) {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); }
	 
	 public void OnFinish(ITestContext testcontext) {
		 extent.flush();
	 }
}

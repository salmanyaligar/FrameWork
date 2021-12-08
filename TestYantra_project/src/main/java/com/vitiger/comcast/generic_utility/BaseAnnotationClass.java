package com.vitiger.comcast.generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vitiger.comcast.pomrepositylib.Home;
import com.vitiger.comcast.pomrepositylib.Login;

public class BaseAnnotationClass {
	public WebDriver driver;
	
	
	//create object
	public Excel_Utility elib=new Excel_Utility();
	public File_Utility flib=new File_Utility();
	public JavaUtlity jlib=new JavaUtlity();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	
	@BeforeSuite
	public void ConfigBs()
	{
		System.out.println("=====connect to DB=====");
		
	}
	
	@BeforeClass
	public void ConfigBc() throws Throwable
	{
		System.out.println("=====launch the browser=====");
		
		String BROWSER=flib.getProperty("browser");
		
		//step1: launch the browser
		if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		
		
		
	}
	
	@BeforeMethod
	public void ConfigBm() throws Throwable
	{
		System.out.println("=======login to application=======");
		
		
		//read common data
				
				String URl=flib.getProperty("url");
				String userName=flib.getProperty("username");
				String password=flib.getProperty("password");
		
		//navigate to app
		driver.get(URl);
		
		Login lp=new Login(driver);
		lp.loginToApp(userName, password);

	}
	
	@AfterMethod
	public void ConfigAm()
	{
		System.out.println("=======logout from application=======");
		Home hp=new Home(driver);
		hp.logout();

	}
	
	@AfterClass
	public void ConfigAc()
	{
		System.out.println("=========close the browser=======");
		driver.quit();
	}
	
	@AfterSuite
	public void ConfigAs()
	{
		System.out.println("========close the data base connection========");
	}
}

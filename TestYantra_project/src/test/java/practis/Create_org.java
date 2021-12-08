package practis;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.Excel_Utility;
import com.vitiger.comcast.generic_utility.File_Utility;

public class Create_org 
{
	@Test
	public void create_organization() throws Throwable
	{
		File_Utility flib=new File_Utility();
		Excel_Utility elib= new Excel_Utility();
		String Browser = flib.getProperty("browser");
		String URL = flib.getProperty("url");
		String User_name = flib.getProperty("username");
		String Password = flib.getProperty("password");
		Random rdno=new Random();
		int Random_Number = rdno.nextInt(100);
		String ORG_Name = elib.getData("Sheet1", 1, 2) + "_" + Random_Number;
		
		String last_name = elib.getData("Sheet1", 1, 3) + "_" + Random_Number;
		
		WebDriver driver;
		if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		} else
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to vitiger
		driver.findElement(By.name("user_name")).sendKeys(User_name);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORG_Name);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		Thread.sleep(8000);
		WebElement org_info = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String org_title = org_info.getText();
		if(org_title.contains(ORG_Name))
		{
			System.out.println("Organization got created");
		} else
		{
			System.out.println("Organization not created");
		}
		
		
		//create contact
		 //WebDriverWait wait1=new WebDriverWait(driver, 10);
		Thread.sleep(5000);
	     driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
	     driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	     driver.findElement(By.name("lastname")).sendKeys(last_name);
	     
	     driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	     
	     Set<String> window = driver.getWindowHandles();
	 	Iterator<String>it=window.iterator();
	 	while(it.hasNext()) {
	 		String winid = it.next();
	 		String title = driver.switchTo().window(winid).getTitle();
	 		
	 		if(title.contains("Accounts&action"))
	 		{
	 			break;
	 		}
	 
	 	}
	 	Thread.sleep(3000);
	 	WebElement search = driver.findElement(By.xpath("//input[@name='search_text']"));
	 	search.sendKeys(ORG_Name);
	 	driver.findElement(By.xpath("//input[@type='button']")).click();
	 	
	 	driver.findElement(By.xpath("//a[.='"+ORG_Name+"']")).click();
	 	
	 	//driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	 	Thread.sleep(5000);
	 	Set<String> window2 = driver.getWindowHandles();
	 	Iterator<String>it2=window2.iterator();

	 	while(it2.hasNext())
	 	{
	 		String windid2 = it2.next();
	 		String windtitle2 = driver.switchTo().window(windid2).getTitle();
	 		if(windtitle2.contains("Administrator - Contacts"))
	 		{
	 			break;
	 		}
	 	}
	 	
	 	Thread.sleep(3000);
	 	driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	 	
	 	//verification
	 	WebDriverWait wait3=new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
		Thread.sleep(8000);
		WebElement Contact_info = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String Contact_title = Contact_info.getText();
		if(Contact_title.contains(last_name))
		{
			System.out.println("Contact got created");
		} else
		{
			System.out.println("Contact not created");
		}
	 	}
}

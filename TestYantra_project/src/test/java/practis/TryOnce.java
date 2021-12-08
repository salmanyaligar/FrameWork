package practis;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.Excel_Utility;
import com.vitiger.comcast.generic_utility.File_Utility;

public class TryOnce {
@Test
public void Demo() throws Throwable
{
	File_Utility flib=new File_Utility();
	Excel_Utility elib=new Excel_Utility();
	 String BROWSER=flib.getProperty("browser");
	 String URL=flib.getProperty("url");
	 String USERNAME=flib.getProperty("username");
	 String PASSWORD=flib.getProperty("password");
	 
	 Random rdno=new Random();
	 int any_no = rdno.nextInt();
	 String org_name = elib.getData("Sheet1", 4, 2) + "_" + any_no;
	 String last_name= elib.getData("Sheet1", 4, 6) + "_" + any_no;
	 
	 WebDriver driver=null;
	 if(BROWSER.equals("firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }else if(BROWSER.equals("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	 driver.get(URL);
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
	 //to create organization
	 driver.findElement(By.xpath("//a[.='Organizations' and @href='index.php?module=Accounts&action=index']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 driver.findElement(By.name("accountname")).sendKeys(org_name);
	 
	 WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
	 Select sel=new Select(ele);
	 sel.selectByVisibleText("Consulting");
	 
	 WebElement ele2 = driver.findElement(By.name("accounttype"));
	 Select sel2=new Select(ele2);
	 sel2.selectByVisibleText("Partner");
	 
	 driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	 
	 //verification
	/* WebDriverWait wait1=new WebDriverWait(driver, 10);
	 wait1.until(ExpectedConditions.titleContains("Organizations"));*/
	 
	 /*WebElement elementname = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	 String var = elementname.getText();
	 System.out.println(var);
	 if(var.contains(org_name)) {
		 System.out.println("organization is created--> pass");
	 }else {
		 System.out.println("organization not created --> failed");	 
	 }*/
	 
	//to create contact
	 WebDriverWait wait=new WebDriverWait(driver, 10);
	// wait.until(ExpectedConditions.titleContains("Contacts")); 
	WebElement contact= driver.findElement(By.xpath("//a[.='Contacts']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", contact);
	//driver.switchTo().alert().accept();
	Thread.sleep(5000);
     driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
     driver.findElement(By.name("lastname")).sendKeys(last_name);
     
     driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
     /*String parent = driver.getWindowHandle();
	 Set<String> all_link = driver.getWindowHandles();
	 all_link.remove(parent);
	 for (String wh: all_link) {
		 driver.switchTo().window(wh);
		 String title = driver.getTitle();
		System.out.println(title);
		return;
	}*/
	 
	 
	Set<String> window = driver.getWindowHandles();
	Iterator<String>it=window.iterator();
	while(it.hasNext()) {
		String winid = it.next();
		String title = driver.switchTo().window(winid).getTitle();
		
		if(title.contains("Accounts&action"))
		{
			break;
		}
		//driver.switchTo().alert();
	}
	Thread.sleep(3000);
	WebElement search = driver.findElement(By.xpath("//input[@type='text' and @id='search_txt']"));
	search.sendKeys(org_name);
	driver.findElement(By.xpath("//input[@type='button']")).click();
	}
}

package practis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.File_Utility;

public class TryTry {
@Test
public void two() throws Throwable {
	File_Utility flib=new File_Utility();
	 String BROWSER=flib.getProperty("browser");
	 String URL=flib.getProperty("url");
	 String USERNAME=flib.getProperty("username");
	 String PASSWORD=flib.getProperty("password");
	 
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
	 
	 
	 
	 
	 
	 
	 
	 
	 driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 driver.findElement(By.name("accountname")).sendKeys("tom");
	 
	 
	 WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
	 Select sel=new Select(ele);
	 sel.selectByVisibleText("Consulting");
	 
	 WebElement ele2 = driver.findElement(By.name("accounttype"));
	 Select sel2=new Select(ele2);
	 sel2.selectByVisibleText("Partner");
	 
	 driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	 
	 
	 driver.findElement(By.xpath("//a[.='Contacts' and @href='index.php?module=Contacts&action=index']")).click();
	 Actions act =new Actions(driver);
	 act.click().perform();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
     driver.findElement(By.name("lastname")).sendKeys("sam");
     
     driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
}
}

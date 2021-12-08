package practis;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.Excel_Utility;
import com.vitiger.comcast.generic_utility.File_Utility;

public class second_try {
@Test
public void CreateContactWithOrg() throws Throwable
{
	File_Utility flib=new File_Utility();
	Excel_Utility elib=new Excel_Utility();
	
	String BROWSER=flib.getProperty("browser");
	String URL=flib.getProperty("url");
	String USERNAME=flib.getProperty("username");
	String PASSWORD=flib.getProperty("password");
	
	// TO GENERATE RANDOM NO..
	Random sno=new Random();
	int rdno = sno.nextInt();
	String NAME_ORG = elib.getData("Sheet1", 4, 2) + "_" + rdno;
	String LAST_NAME = elib.getData("Sheet1", 4, 6) + "_" + rdno;
	
	WebDriver driver=null;
	if(BROWSER.equals("firefox"))
	{
	  driver=new FirefoxDriver();	
			}else if (BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}
	driver.get(URL);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	
	//CREATE ORGANIZATION
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("accountname")).sendKeys(NAME_ORG);
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	
	//verification 
	Thread.sleep(10000);
	WebElement sub_title = driver.findElement(By.className("dvHeaderText "));
	String txt = sub_title.getText();
	System.out.println(txt);
	if (txt.contains(NAME_ORG)) {
		System.out.println("organization is created test pass");
	}else {
		System.out.println("organization is not created failed");
	}
	
	
	
	
	
	
			


}
}

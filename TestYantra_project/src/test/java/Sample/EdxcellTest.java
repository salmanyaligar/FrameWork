package Sample;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vitiger.comcast.generic_utility.Excel_Utility;
import com.vitiger.comcast.generic_utility.File_Utility;

public class EdxcellTest {
@Test
public void one(XmlTest xml) throws Throwable, IOException
{  
	Excel_Utility uti=new Excel_Utility();

    String BROWSER= xml.getParameter("browser");
    String URL=xml.getParameter("url");
    String USERNAME=xml.getParameter("username");
    String PASSWORD=xml.getParameter("password");
    Random rdno=new Random();
    int rn = rdno.nextInt();
    
    String sal = uti.getData("Sheet1",1,2) + "_" + rn ;	    
    WebDriver driver=null;
    if(BROWSER.equals("firefox"))
    {
    	driver=new FirefoxDriver();
    }else if(BROWSER.equals("chrome"))
    {
    	driver=new ChromeDriver();
    }
    driver.get(URL);
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    driver.findElement(By.xpath("//a[.='Organizations']")).click();
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    WebElement ele = driver.findElement(By.xpath("//input[@type='text' and @name='accountname']"));
    ele.sendKeys(sal);
    driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
    
}
}

package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vitiger.comcast.generic_utility.File_Utility;

public class PropTest {
@Test
public void prop(XmlTest xml) {    
    String BROWSER=xml.getParameter("browser");
    String URL=xml.getParameter("url");
    String USERNAME=xml.getParameter("username");
    String PASSWORD=xml.getParameter("password");
    
    WebDriver driver=null;
    if(BROWSER.equals("firefox"))
    {
    	driver=new FirefoxDriver();
    }else if(BROWSER.equals("chrome"))
    {
    	driver=new ChromeDriver();
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
    driver.get(URL);
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    driver.findElement(By.xpath("//a[.='Organizations']")).click();
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys("SBI");
    driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
    
}
}

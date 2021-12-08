package TestYantra_project.TestYantra_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vitiger.comcast.generic_utility.Excel_Utility;
import com.vitiger.comcast.generic_utility.File_Utility;

public class DataDriverTestingByExel {
public static void main(String[] args) throws Throwable {
			File_Utility flib=new File_Utility();
		    
		    String BROWSER=flib.getProperty("browser");
		    String URL=flib.getProperty("url");
		    String USERNAME=flib.getProperty("username");
		    String PASSWORD=flib.getProperty("password");
		    
		    Excel_Utility uti=new Excel_Utility();
		    String sal = uti.getData("Sheet1",1,2);	    
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
		    driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys(sal);
		    driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		    
		}


}

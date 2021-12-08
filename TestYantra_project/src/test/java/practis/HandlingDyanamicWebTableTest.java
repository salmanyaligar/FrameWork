package practis;

import static org.testng.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.File_Utility;

public class HandlingDyanamicWebTableTest {
     WebDriver driver;
	@Test
	public void HDWT() throws Throwable
	{
		File_Utility flib=new File_Utility();
		String Browser = flib.getProperty("browser");
		String URL = flib.getProperty("url");
		String USERNAME = flib.getProperty("username");
		String PASSWORD = flib.getProperty("password");
		
		//open the browser
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		//enter the url
		driver.get(URL);
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on org
		driver.findElement(By.linkText("Organizations")).click();
		//List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/input"));
		/*for(int i=1;i<ele.size();i++)
		{
			ele.get(i).click();
		}*/
		
		//select last
		//ele.get(ele.size()-1).click();
		
		//select 5
		//ele.get(5).click();
		
		List<WebElement> orgname = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		String name = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[3]/a")).getText();
		System.out.println(name);
		
		for(int i=1;i<orgname.size();i++)
		{
			if(name.equals(orgname.get(i).getText()))
					{
				System.out.println(name +" matches");
						driver.findElement(By.xpath("//a[.='"+name+"']/../following-sibling::td[5]/a[.='del']")).click();
						driver.switchTo().alert().accept();
						System.out.println(name + " deleted ");
						break;
					}
		}
		System.out.println("no matching organization");
		
	}
}

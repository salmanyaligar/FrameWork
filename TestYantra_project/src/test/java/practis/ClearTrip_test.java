package practis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClearTrip_test {

	@Test
	public void ClearTTestcase() throws Throwable
	{
		   WebDriver driver=new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.cleartrip.com/");
			
		   //select src
			WebElement src = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]"));
			src.sendKeys("BOM");
			
		Thread.sleep(5000);
			driver.findElement(By.xpath("//p[.='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
			
			//select destination
			WebElement dst = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]"));
			dst.sendKeys("maa");
			driver.findElement(By.xpath("//p[.='Chennai, IN - Chennai Airport (MAA)']")).click();
			
			
			//select departure date
			WebElement ele = driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']"));
			ele.click();
			
			//generic file for date
			Date dateobj=new Date();
			String date = dateobj.toString();
			System.out.println(date);
			String[] today = date.split(" ");
			
			String day=today[0];
			String month=today[1];
			String actDate=today[2];
			String year=today[5];
			
			String traveldate = day+" "+month+" "+actDate+" "+year;
			System.out.println(traveldate);
			
			//select departure date
			driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
			
			System.out.println("flight booking confirmed");
	}
}

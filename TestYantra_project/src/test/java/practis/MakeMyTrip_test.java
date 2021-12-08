package practis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MakeMyTrip_test {

	@Test
	public void MMT()
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		//select src
		WebElement src = driver.findElement(By.xpath("//span[.='From']"));
		src.click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BOM");
		driver.findElement(By.xpath("//P[.='Mumbai, India']")).click();
		
		//select destination
		WebElement dst = driver.findElement(By.xpath("//input[@placeholder='To']"));
		dst.click();
		dst.sendKeys("maa");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
		
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

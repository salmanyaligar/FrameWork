package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generic_utility.WebDriverUtility;

public class Organizations {
	WebDriver driver;
	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgImg;

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}	
	
	@FindBy(name="search_text") // org search textfield
	private WebElement searchtxt;

	public WebElement getSearchtxt() {
		return searchtxt;
	}
	
	@FindBy(name="search")   //org search button
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	WebDriverUtility wlib=new WebDriverUtility();
	
	public void SelectOrganization(String orgName) throws InterruptedException
	{
		//wlib.waitForElementVisibility(driver, searchBtn);
		wlib.switchToWindow(driver,"Accounts&action");
		//wlib.waitForElementVisibility(driver, getSearchtxt());
		Thread.sleep(5000);
		getSearchtxt().sendKeys(orgName);
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		wlib.switchToWindow(driver,"Contacts&action");
		Contacts cp=new Contacts(driver);
		cp.getSaveBtn().click();
	}
	
}

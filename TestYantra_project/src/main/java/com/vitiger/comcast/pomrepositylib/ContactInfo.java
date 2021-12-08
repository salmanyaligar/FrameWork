package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {

	public ContactInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement Contactheader;
	
	public WebElement getContactheader() {
		return Contactheader;
	}

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}
}

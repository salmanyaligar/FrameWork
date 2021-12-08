package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']") // create btn in contact page
	private WebElement createcontactIcon;

	public WebElement getCreatecontactIcon() {
		return createcontactIcon;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]'and @class='crmbutton small save']") // save btn in contact page
	private WebElement SaveBtn;

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	
	
}

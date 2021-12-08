package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.generic_utility.WebDriverUtility;

public class CreateNewOrganization {
		public CreateNewOrganization(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name ="accountname")
		private WebElement orgNameEdt;
		
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		@FindBy(name="industry")
		private WebElement Industrydropdown;
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		@FindBy(name = "accounttype")
		private WebElement typedropdown;
		
		public WebElement getTypedropdown() {
			return typedropdown;
		}



		public WebElement getIndustrydropdown() {
			return Industrydropdown;
		}

		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		public void createOrg(String orgName) throws Throwable
		{
			orgNameEdt.sendKeys(orgName);
			Thread.sleep(5000);
			saveBtn.click();
		}
}

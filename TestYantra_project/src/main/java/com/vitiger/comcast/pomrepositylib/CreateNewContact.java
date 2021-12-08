package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
		
		public CreateNewContact(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getLastName() {
			return lastNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
		private WebElement selectOrganization;
		
		
		public WebElement getSelectOrganization() {
			return selectOrganization;
		}

		public void createCon(String lastName)
		{
			lastNameEdt.sendKeys(lastName);
			saveBtn.click();
		}
}

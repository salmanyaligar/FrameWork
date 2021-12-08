package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
   public Home(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(linkText ="Organizations")
   private WebElement organizationLink;
   
   @FindBy(linkText ="Products")
   private WebElement productLink;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminstatorImg;
   
   @FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
   private WebElement contactLink;
   
   public WebElement getContactLink()
   {
	return contactLink;
   }

   @FindBy(xpath = "//a[@class='drop_down_usersettings' and .='Sign Out']")
   private WebElement signOutLink;
   
   
   public WebElement getOrganizationLink() 
   {
	return organizationLink;
   }

   public WebElement getProductLink() 
   {
	return productLink;
   }

   public WebElement getAdminstatorImg() 
   {
	return adminstatorImg;
   }

   public WebElement getSignOutLink() 
   {
	return signOutLink;
   }
	
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminstatorImg).perform();
		signOutLink.click();
	}
	
}

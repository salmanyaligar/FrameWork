package com.vitiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login { //Rule :1 Create a seperate java class for every page in a application
	WebDriver driver;
	public Login(WebDriver driver) //Rule 3:Execute all the elements & initalize the elements PageFactory.initElements[initialization]
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="user_name")    //Rule 2:Identify all the elements using @FindBy &findbys,findAll (Declaration)
	private WebElement userNameEdt;

	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton") , @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	//Rule 4: Declare all the elements as private & provide getters method , business method for (utilization)

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String userName , String password)
	{
		/* step1: login */
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
}

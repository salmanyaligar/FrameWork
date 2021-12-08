package com.vitiger.com.cast.execute;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;
import com.vitiger.comcast.pomrepositylib.Contacts;
import com.vitiger.comcast.pomrepositylib.CreateNewContact;
import com.vitiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vitiger.comcast.pomrepositylib.Home;
import com.vitiger.comcast.pomrepositylib.Organizations;

public class CreateContactWithOrganization  extends BaseAnnotationClass{

	@Test
	public void createcontact_organization() throws Throwable
	{
		
	              
				String orgName = elib.getData("sheet1", 4, 2) + "_" + jlib.getRanDomNumber();
				String lastName=elib.getData("sheet1", 4, 3) + "_" + jlib.getRanDomNumber();
				
				//navigate to contact link
				Home hp=new Home(driver);
				
				//create org first the go for create contact with org
				hp.getOrganizationLink().click();
				
				Organizations org=new Organizations(driver);
				org.getCreateOrgImg().click();
				
				CreateNewOrganization crtorg=new CreateNewOrganization(driver);
				crtorg.createOrg(orgName);
				
				Thread.sleep(5000);
				// create contact with org
				hp.getContactLink().click();
				
				//navigate to contact icon
				Contacts con=new Contacts(driver);
				con.getCreatecontactIcon().click();
				
				CreateNewContact cp=new CreateNewContact(driver);
				cp.getLastName().sendKeys(lastName);
				
				
				cp.getSelectOrganization().click();
				Thread.sleep(5000);
			    wlib.switchToWindow(driver,"Accounts&action");
				Organizations orgp=new Organizations(driver);
				orgp.getSearchtxt().sendKeys(orgName);
				orgp.getSearchBtn().click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
				Thread.sleep(8000);
				wlib.switchToWindow(driver, "Contacts&action");
				cp.getSaveBtn().click();
	}
}
package com.vitiger.com.cast.execute;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;
import com.vitiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vitiger.comcast.pomrepositylib.Home;
import com.vitiger.comcast.pomrepositylib.Organizations;

public class CreateOrganizationWithIndustryType extends BaseAnnotationClass{

	@Test
	public void createorgwithindandtyp() throws Throwable
	{	
		String orgName = elib.getData("sheet1", 4, 2) + "_" + jlib.getRanDomNumber();
	
		//step3: navigate to contact link
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		Organizations orgp=new Organizations(driver);
		orgp.getCreateOrgImg().click();
	
		CreateNewOrganization crtorg=new CreateNewOrganization(driver);
		crtorg.getOrgNameEdt().sendKeys(orgName);
		
		WebElement inWeb = crtorg.getIndustrydropdown();
		wlib.select(inWeb, "Energy");
		
		WebElement tyWeb =crtorg.getTypedropdown();
		wlib.select(tyWeb, "Press");
		
		crtorg.getSaveBtn().click();
		Thread.sleep(5000);
	}
}

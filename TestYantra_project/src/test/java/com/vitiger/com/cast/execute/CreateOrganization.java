package com.vitiger.com.cast.execute;

import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;
import com.vitiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vitiger.comcast.pomrepositylib.Home;
import com.vitiger.comcast.pomrepositylib.Organizations;

public class CreateOrganization extends BaseAnnotationClass {
		@Test
		public void Createorg() throws Throwable
		{
			
			String orgName = elib.getData("sheet1", 4, 2) + "_" + jlib.getRanDomNumber();
			
			//step3: navigate to contact link
			Home hp=new Home(driver);
			hp.getOrganizationLink().click();
			
			Organizations org=new Organizations(driver);
			org.getCreateOrgImg().click();
			
			CreateNewOrganization crtorg=new CreateNewOrganization(driver);
			crtorg.createOrg(orgName);
			Thread.sleep(5000);
		
		}
}

package com.vitiger.com.cast.execute;

import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;
import com.vitiger.comcast.pomrepositylib.ContactInfo;
import com.vitiger.comcast.pomrepositylib.Contacts;
import com.vitiger.comcast.pomrepositylib.CreateNewContact;
import com.vitiger.comcast.pomrepositylib.Home;

public class CreateContactTest extends BaseAnnotationClass{
	@Test
	public void CreateContact() throws Throwable
	{
		//read test data
		//String orgName=elib.getData("Sheet1", 4, 2) + "-" + jlib.getRanDomNumber();
		String lastName=elib.getData("Sheet1", 4, 3) + "-" + jlib.getRanDomNumber();
		
		
		//step3: navigate to contact link
		Home hp=new Home(driver);
		hp.getContactLink().click();
		
		//step4: navigate to create contact page
	    Contacts cp=new Contacts(driver);
	    cp.getCreatecontactIcon().click();
	    
	    //step5: create contact
	    CreateNewContact cnc=new CreateNewContact(driver);
	    cnc.createCon(lastName);
		
		//step6: verification
	    ContactInfo conver=new ContactInfo(driver);
	    wlib.waitForElementVisibility(driver,conver.getContactheader());
	    String actcon = conver.getContactheader().getText();
	    if(actcon.contains(lastName))
	    {
	    	System.out.println("contact is created ==> pass");
	    }else {
	    	System.err.println("contact not created ==> Fail");
	    }
	    
	}
}

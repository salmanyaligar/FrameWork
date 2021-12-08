package sample_batchexe_with_annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vitiger.comcast.generic_utility.BaseAnnotationClass;
import com.vitiger.comcast.pomrepositylib.ContactInfo;
import com.vitiger.comcast.pomrepositylib.Contacts;
import com.vitiger.comcast.pomrepositylib.CreateNewContact;
import com.vitiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vitiger.comcast.pomrepositylib.Home;
import com.vitiger.comcast.pomrepositylib.Organizations;

public class Sample  extends BaseAnnotationClass{

	//org
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
	
	//org with ind
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
	
	//create contact
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
	// contact with org
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

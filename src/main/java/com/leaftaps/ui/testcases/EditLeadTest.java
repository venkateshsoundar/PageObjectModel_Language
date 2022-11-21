package com.leaftaps.ui.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.projectspecific;
import com.leaftaps.ui.pages.LoginPage;

public class EditLeadTest extends projectspecific{

	@BeforeTest
	public void setdata() {
		filename="LeafTaps";
		sheetname="EditLead";
	}


	@Test(dataProvider = "provideData")
	public void runEditLead(String username, String password, String cname, String firstname, String lastname,String phonenum,String updatecompanyname) throws InterruptedException {
		
		
		LoginPage pg=new LoginPage(driver);
		pg.Enterusername(username)
		.Enterpassword(password)
		.ClickLogin_Positive()
		.ClickCRMSFA()
		.ClickLeads()
		.ClickCreateLead()
		.EnterCompanyname(cname)
		.EnterfirstName(firstname)
		.EnterlastName(lastname)
		.EnterPhonenumber(phonenum)
		.ClickSubmit()
		.VerifyLeadID()
		.ClickFindLeads()
		.Clickphonetab()
		.EnterPhoneNumber(phonenum)
		.ClickFind()
		.SelectLeadId()
		.ClickEdit()
		.ModifyCompanyname()
		.Clickupdate()
		.VerifyCompanyname(updatecompanyname);
		
	}

}

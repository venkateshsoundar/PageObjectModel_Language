package com.leaftaps.ui.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.projectspecific;
import com.leaftaps.ui.pages.LoginPage;

public class CreateLeadTest extends projectspecific{

	@BeforeTest
	public void setdata() {
		filename="LeafTaps";		
		sheetname="Createlead";
	}


	@Test(dataProvider = "provideData")
	public void runCreateLead(String username, String password, String cname, String firstname, String lastname) {
		
		
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
		.ClickSubmit()
		.VerifyLeadID();		
	}

}

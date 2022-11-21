package com.leaftaps.ui.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.projectspecific;
import com.leaftaps.ui.pages.LoginPage;

public class MergeLeadTest extends projectspecific{
	
	@BeforeTest
	public void setdata() {
		filename="LeafTaps";
		sheetname="MergeLead";
	}


	@Test(dataProvider = "provideData")
	public void runMergeLead(String username, String password, String cname, String firstname, String lastname,
			String cname1, String firstname1, String lastname1) throws InterruptedException {
		
	
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
		.VerifyLeadID()
		.ClickCreatelead()
		.EnterCompanyname(cname1)
		.EnterfirstName(firstname1)
		.EnterlastName(lastname1)	
		.ClickSubmit()
		.ClickMergeLeads()
		.ClickComboBox("from")
		.Switchwindows()
		.Enterfirstname(firstname)
		.ClickFind()
		.SelectLead()
		.Switchmain()
		.ClickComboBox("to")
		.Switchwindows()		
		.Enterfirstname(firstname1)
		.ClickFind()
		.SelectLead()
		.Switchmain()
		.ClickMerge()
		.ClickFindLeads()
		.EnterLeadID()
		.ClickFind()
		.VerifyMerge();
		
		
		
		
	
	}


}

package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class EditLeadPage extends projectspecific{
	
	public String leadid;
	public String phonenum;
	
	public  EditLeadPage(RemoteWebDriver receiveddriver) {
		this.driver=receiveddriver;
	}
	
	public EditLeadPage ModifyCompanyname() {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		return this;
	}
	
	public ViewLeadPage Clickupdate() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
		
	}

}

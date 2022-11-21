package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class CreateLeadpage extends projectspecific{

	public CreateLeadpage(RemoteWebDriver receiveddriver) {
		this.driver=receiveddriver;
	}
	
	public CreateLeadpage EnterCompanyname(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		return this;
		
	}
	
	public CreateLeadpage EnterfirstName(String firstname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		return this;
	}
	public CreateLeadpage EnterlastName(String lastname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		return this;
	}
	
	public CreateLeadpage EnterPhonenumber(String phonenum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenum);
		return this;
	}
	
	
	public ViewLeadPage ClickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}
	
	
	


	
}

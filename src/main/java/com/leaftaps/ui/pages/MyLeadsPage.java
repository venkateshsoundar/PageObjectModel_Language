package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class MyLeadsPage extends projectspecific {

	

	public MyLeadsPage(RemoteWebDriver receiveddriver) {
		this.driver = receiveddriver;
	}

	
	
	public CreateLeadpage ClickCreateLead() {
		driver.findElement(By.linkText(prop.getProperty("MyLeadsPage.ClickCreateLead.CreateLead"))).click();
		return new CreateLeadpage(driver);
	}
	
	
	
}

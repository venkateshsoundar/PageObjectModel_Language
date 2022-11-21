package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class HomePage extends projectspecific{

	public  HomePage(RemoteWebDriver receiveddriver) {
		this.driver=receiveddriver;
	}
	
	public MyLeadsPage ClickLeads() {
		driver.findElement(By.linkText(prop.getProperty("HomePage.Clickleads.leads"))).click();
		return new MyLeadsPage(driver);
	}
	
}

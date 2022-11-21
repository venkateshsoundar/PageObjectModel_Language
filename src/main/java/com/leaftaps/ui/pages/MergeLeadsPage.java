package com.leaftaps.ui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class MergeLeadsPage extends projectspecific {
	
	Set<String> allWindows;
	List<String> allhandles;

	public MergeLeadsPage(RemoteWebDriver receiveddriver, String leadid) {
		this.driver = receiveddriver;
		this.Leadid = leadid;
	}

	public MergeLeadsPage ClickComboBox(String type) {
		if (type.equalsIgnoreCase("from")) {			
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			}
		else {			
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		}
		return this;
	}

	public MergeLeadsPage Switchwindows() throws InterruptedException {
		allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		return this;
	}
	
	public MergeLeadsPage Switchmain() throws InterruptedException {		
		driver.switchTo().window(allhandles.get(0));
		return this;
	}

	public MergeLeadsPage Enterfirstname(String fname) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
		return this;
	}

	public MergeLeadsPage ClickFind() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public MergeLeadsPage SelectLead() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
	}
	
	

	public ViewLeadPage ClickMerge() {
    String Leadid = driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']")).getAttribute("valuenow");
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		return new ViewLeadPage(driver,Leadid);
	}

}

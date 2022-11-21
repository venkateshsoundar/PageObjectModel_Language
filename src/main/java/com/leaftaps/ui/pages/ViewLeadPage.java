package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ViewLeadPage extends projectspecific {

	public ViewLeadPage(RemoteWebDriver receiveddriver) {
		this.driver = receiveddriver;

	}

	public ViewLeadPage(RemoteWebDriver receiveddriver, String leadid) {
		// TODO Auto-generated constructor stub
		this.driver = receiveddriver;
		this.Leadid = leadid;
	}

	public ViewLeadPage VerifyLeadID() {
		Leadid = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		Leadid = Leadid.replaceAll("[()]", "");
		Leadid = Leadid.substring(Leadid.length() - 5);
		System.out.println(Leadid);
		return this;
	}

	public ViewLeadPage VerifyCompanyname(String updcname) {
		Leadid = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String Split[] = Leadid.split(" ");
		Leadid = Split[0];
		if (updcname.equalsIgnoreCase(Leadid)) {
			System.out.println(Leadid);
			System.out.println("Companyname is updated Successfully");
		}
		return this;
	}

	public ViewLeadPage Verifyphonenum(String Phonenum) {
		phonenum = driver.findElement(By.xpath("//table[@class='contactTable']//tr[2]/td[2]")).getText();
		phonenum = phonenum.substring(2);
		if (Phonenum.equalsIgnoreCase(phonenum)) {
			System.out.println(phonenum);
			System.out.println("Phonenumber is updated Successfully");
		}
		return this;
	}

	public FindLeadsPage ClickFindLeads() {

		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		return new FindLeadsPage(driver, Leadid);

	}

	public EditLeadPage ClickEdit() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);

	}

	public ViewLeadPage Clickdelete() {
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		return this;
	}
	
	
	public CreateLeadpage ClickDuplicate() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new CreateLeadpage(driver);
	}
	public CreateLeadpage ClickCreatelead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadpage(driver);
	}
	
	
	public MergeLeadsPage ClickMergeLeads() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLeadsPage(driver,Leadid);
	}
	


}

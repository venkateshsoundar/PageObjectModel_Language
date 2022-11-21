package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class FindLeadsPage extends projectspecific {

	public FindLeadsPage(RemoteWebDriver receiveddriver, String leadid) {
		this.driver = receiveddriver;
		this.Leadid = leadid;
	}

	public FindLeadsPage(RemoteWebDriver receiveddriver) {
		this.driver = receiveddriver;
	}

	public FindLeadsPage Clickphonetab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}

	public FindLeadsPage EnterPhoneNumber(String phonenum) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenum);
		return this;
	}

	public FindLeadsPage EnterLeadID() {		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(Leadid);
		return this;
	}

	
	public FindLeadsPage ClickFind() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}

	public ViewLeadPage SelectLeadId() {
		driver.findElement(By.xpath("//a[text()='" + Leadid + "']")).click();
		return new ViewLeadPage(driver, Leadid);
	}
	
	

	public void VerifyLeadDelete() {
		boolean nrverify = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (nrverify) {
			System.out.println("Lead has been sucessfully deleted");
		} else {
			System.out.println("Lead is not  deleted");
		}

	}
	
	public void VerifyMerge() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Lead ID merged Successfully");
		} else {
			System.out.println("Lead ID not merged Successfully");
		}
	}

}

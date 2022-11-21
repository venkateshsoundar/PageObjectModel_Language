package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.projectspecific;

public class WelcomePage extends projectspecific{
	public  WelcomePage(RemoteWebDriver receiveddriver) {
		this.driver=receiveddriver;
	}
	public HomePage ClickCRMSFA(){
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage(driver);
	}
	
	public LoginPage ClickLogout(){
		driver.findElement(By.linkText("Logout")).click();	
		return new LoginPage(driver);
	}
	
}
	
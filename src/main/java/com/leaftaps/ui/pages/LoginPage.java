package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.base.projectspecific;

public class LoginPage extends projectspecific {
	
	public LoginPage(RemoteWebDriver receiveddriver) {
		this.driver=receiveddriver;
		PageFactory.initElements(receiveddriver, this);
	}
	
	@FindBy(how=How.ID,using="username") WebElement usrname;


	public LoginPage Enterusername(String username) {		
		usrname.sendKeys(username);
		return this;
	}
	
	@FindBy(how=How.ID,using="password") WebElement passwd;
	
	public LoginPage Enterpassword(String password) {		
		passwd.sendKeys(password);
		return this;
	}
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit") WebElement submit;
	
	public WelcomePage ClickLogin_Positive() {
		submit.click();
		return new WelcomePage(driver);
	}
	
	public LoginPage ClickLogin_Negative() {
		submit.click();
		return this;
	}
	


}

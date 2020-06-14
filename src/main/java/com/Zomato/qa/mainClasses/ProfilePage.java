package com.Zomato.qa.mainClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Zomato.qa.Base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends Base
{
	//AndroidDriver<AndroidElement> driver
	public ProfilePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "text(\"Settings\")")
	public WebElement settings;
	
	@AndroidFindBy(uiAutomator = "text(\"Profile\")")
	public WebElement profile;
	
	@AndroidFindBy(uiAutomator = "text(\"Edit profile\")")
	public WebElement editprofile;
	
	@AndroidFindBy(uiAutomator = "text(\"Add Photo\")")
	public WebElement addphoto;
	
	@AndroidFindBy(className = "android.view.View")
	public List <WebElement> picselect;
	
	@AndroidFindBy(uiAutomator = "text(\"Preview\")")
	public WebElement preview;
	
	@AndroidFindBy(uiAutomator = "text(\"Done\")")
	public WebElement done;
	
	public void Operation() throws InterruptedException
	{
		settings.click();
		editprofile.click();
		addphoto.click();
		picselect.get(1).click();
		Thread.sleep(4000);
		preview.click();
		done.click();		
	}
		
}

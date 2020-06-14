package com.Zomato.qa.mainClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Zomato.qa.Base.Base;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends Base
{
	public HomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "text(\"Search for restaurants, cuisines…\")")
	public WebElement searchforrestaurant;
	
	@AndroidFindBy(uiAutomator = "text(\"Profile\")")
	public WebElement profile;
	
	public void typerestro()
	{
		searchforrestaurant.click();
	}
	
	public void clickOnProfile()
	{
		profile.click();
	}
	
	

}	









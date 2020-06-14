package com.Zomato.qa.mainClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Zomato.qa.Base.Base;
import com.Zomato.qa.Util.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchingPage extends Base
{
	public SearchingPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[(@text='Start typing…')]")
	public WebElement typing;
	
	@AndroidFindBy(uiAutomator = "text(\"Indian\")")
	public WebElement indianCuisine;
	
	@AndroidFindBy(className = "android.widget.LinearLayout")
	public List<WebElement> restro;
	
	public void selectingIndianCuisine()
	{
		Utility.ActionClass(typing);
		indianCuisine.click();
		restro.get(1).click();
		
	}
	
	
}

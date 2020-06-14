package com.Zomato.qa.Util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Zomato.qa.Base.Base;

public class Utility extends Base
{
    public static Actions action = new Actions(driver);
                    
	
	public static void ActionClass(WebElement ele)
	{
		action.moveToElement(ele).sendKeys("indian").build().perform();
	}
	
}

package com.Zomato.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base 

{
	
	public static AppiumDriver<MobileElement> driver;
    public static File file;
	public static FileInputStream input;
	public static Properties prop;
	public static AppiumDriverLocalService service;
	
	public static AppiumDriverLocalService startServer()
	{
	
	boolean flag = checkIfServerIsRunnning(4723);
	
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

 	public static void startEmulator() throws IOException, InterruptedException
    {

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Zomato\\qa\\Resources\\emulator.bat");
	//Thread.sleep();
    
    }

    public static AppiumDriver<MobileElement> capabilities() throws IOException, InterruptedException	
    {
		
		//Initializing Properties Files
		try
		{
			file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Zomato\\qa\\Configuration\\zomato.properties");	
			input = new FileInputStream(file);
			prop = new Properties();
			prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		//Initializing Properties File Done
		 
		//File f = new File("InterviewTikMe");
		//File fs = new File(f, "zomatoo.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		String p = prop.getProperty("DeviceType");
		System.out.println(p);
		if(p.equals("Android device"))
		{
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		}
		
		else 
		{	
		  startEmulator();
		  Thread.sleep(20000);
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));
		}
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "Zomato");
		//cap.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		
		//cap.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\pranay.jaroli\\eclipse-workspace\\InterviewTikMe\\zomatoo.apk");
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("autoGrantPermissions",true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		
		//=======================================
		
		cap.setCapability("appPackage","com.application.zomato");
		cap.setCapability("appActivity","com.application.zomato.activities.Splash *");
		
		
		
		
		//========================================
		
		//cap.setCapability("appWaitPackage", "com.application.zomato");
		//cap.setCapability("appWaitActivity", "com.application.zomato.*");
		
		//cap.setCapability("appWaitPackage", "com.application.zomato");
	    cap.setCapability("unicodeKeyboard", false);
		cap.setCapability("resetKeyboard", false);
		
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE , "com.application.zomato");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY , "com.application.zomato.actvities.*");
		
		//cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,"com.application.zomato.actvities.ZomatoActivity" );
		
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);			
		return driver;
      }

	
}

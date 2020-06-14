package InterviewTikMe.InterviewTikMe;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Zomato.qa.Base.Base;
import com.Zomato.qa.mainClasses.HomePage;
import com.Zomato.qa.mainClasses.ProfilePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ProfilePictureTest extends Base
{
   
   public ProfilePictureTest()
   {
	   super();
	   
   }
   public AppiumDriverLocalService service;
   
   
   @BeforeTest
   public void taskkill() throws IOException
   {
	   Runtime.getRuntime().exec("taskkill /F /IM node.exe");
   }
   
   @Test
   public void setup() throws InterruptedException, IOException
   {
	   service = startServer();
	   Thread.sleep(20000);
	   AppiumDriver<MobileElement> driver = capabilities();
	   HomePage page = new HomePage();
	   ProfilePage pro = new ProfilePage();
	   page.clickOnProfile();
	   pro.Operation();
	   service.stop();
	   
	   
   }
   
   
}

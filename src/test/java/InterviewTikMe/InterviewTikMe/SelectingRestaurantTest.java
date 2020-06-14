package InterviewTikMe.InterviewTikMe;

import java.io.IOException;
//import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.Zomato.qa.Base.Base;
import com.Zomato.qa.mainClasses.HomePage;
import com.Zomato.qa.mainClasses.ProfilePage;
import com.Zomato.qa.mainClasses.SearchingPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class SelectingRestaurantTest extends Base
{
   public AppiumDriverLocalService service;
   public SelectingRestaurantTest()
   {
	   
   }
   
   @Test
   public void setup() throws InterruptedException, IOException
   {
	   service = startServer();
	   AppiumDriver<MobileElement> driver = capabilities();
	   HomePage page = new HomePage();
	   ProfilePage pro = new ProfilePage();
	   SearchingPage search = new SearchingPage();
	   page.typerestro();
	   search.selectingIndianCuisine();
	   service.stop();
	   
   }
}

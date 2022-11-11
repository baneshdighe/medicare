package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginAsUser;
import pages.UserHomePage;
import resources.Base;

public class UserTest extends Base{
	
	WebDriver driver;
	LoginAsUser logUser;
	UserHomePage uh;
	
	@Test(priority=1)
	public void UserTestCases() throws IOException {
		
		driver = initializeDriver();
		driver.get("http://localhost:8081/medicare/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		 logUser = new LoginAsUser(driver);
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logUser.clickOnLoginButton();
		
		
		
		
	}
	@Test(priority=2)
	public void valCredTest() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logUser.UserLoginWithValidCredentials();
		
	}
	
	
	//@Test(priority=3)
	public void TestUserPageEle() {
		logUser.ActWebEleVAl();
	}
	@Test(priority=3)
	public void UserHomeTest() {
		 uh = new UserHomePage(driver);
		
		 uh.ChooseMed();
		 uh.Checkoout();
		 uh.DeliveryPayAddress();
		 
		 
	}
	

}

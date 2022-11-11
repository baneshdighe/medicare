package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminHomePage;
import pages.LoginAsAdmin;
import resources.Base;

public class AdminTest extends Base{
	
	WebDriver driver;
	
	@Test(priority=1)
	public void AdminCredLoginTest() throws IOException {
		
		driver= initializeDriver();
		driver.get("http://localhost:8081/medicare/");
	
		LoginAsAdmin LA = new LoginAsAdmin(driver);
		
		LA.clickOnLoginButton();
		LA.AdminLoginWithValidCredentials();
		
	}
	
	@Test(priority=2)
	public void AdminProdManag() {
		
		AdminHomePage AH = new AdminHomePage(driver);
		AH.ExpPageAuth();
		AH.ManageProducts();
		
		
	}
}

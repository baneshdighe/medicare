package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.SignUpOrAddNewUser;
import resources.Base;

public class SignUpTest extends Base{
	WebDriver driver;
	
	@Test
	public void sign_up_testcases() throws IOException {
		
		driver = initializeDriver();
		driver.get("http://localhost:8081/medicare/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		SignUpOrAddNewUser su = new SignUpOrAddNewUser(driver);
		su.SignUpButton();
		
		driver.close();
	}

}

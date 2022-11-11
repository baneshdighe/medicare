package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAsAdmin {
	
	WebDriver driver;
	
	public LoginAsAdmin(WebDriver driver) {
		this.driver=driver;
		
	}

	
	public void clickOnLoginButton() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//click on login
		driver.findElement(By.id("login")).click();
		
		
	}
	public void AdminLoginWithValidCredentials() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//Enter user name in Email field
		WebElement Email = driver.findElement(By.id("username"));
		
		boolean emailField = Email.isEnabled();
		
		
		if(emailField) {
			
		Email.clear();
		Email.sendKeys("vk@gmail.com");
		
		}else {
			System.out.println("Email field not enabled");
			
		}
		
		//Enter paasword in Password Field
		WebElement Password = driver.findElement(By.id("password"));
		
		boolean passwordField = Password.isEnabled();
		
		if(passwordField) {
			
		
		Password.clear();
		Password.sendKeys("admin");
		
		}else {
			System.out.println("Password field is not enabled");
		}
		
		//Click on Login button
//		WebElement LoginButton = driver.findElement(By.className("btn btn-primary"));
//		
//		
//			
//			LoginButton.click();
			
	
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		WebElement LoginButton = driver.findElement(By.xpath("//input[@type='submit']"));



		// Scroll the browser to the element's Y position

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+LoginButton.getLocation().y+")");



		// Click the element

		LoginButton.click();
		
		
	}
	public void AuthExpectedAdmin() {
		//Authenticate That the actual admin is logedin with the given credentials
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		WebElement expectedAdminNameElement = driver.findElement(By.className("btn btn-default dropdown-toggle"));
		Assert.assertEquals(expectedAdminNameElement, "Vikas Kashyap");
		
		
		
		
		
	}
}

package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAsUser {
	WebDriver driver;
	
	public LoginAsUser(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnLoginButton() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//click on login
		driver.findElement(By.id("login")).click();
		
		
	}
	public void UserLoginWithValidCredentials() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//Enter user name in Email field
		WebElement Email = driver.findElement(By.id("username"));
		
		boolean emailField = Email.isEnabled();
		
		
		if(emailField) {
			
		Email.clear();
		Email.sendKeys("kn@gmail.com");
		
		}else {
			System.out.println("Email field not enabled");
			
		}
		
		//Enter paasword in Password Field
		WebElement Password = driver.findElement(By.id("password"));
		
		boolean passwordField = Password.isEnabled();
		
		if(passwordField) {
			
		
		Password.clear();
		Password.sendKeys("12345");
		
		}else {
			System.out.println("Password field is not enabled");
		}
		
		//Click on Login button
		WebElement LoginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		
//		boolean LoginButtonIs =LoginButton.isEnabled();
//		
//		if(LoginButtonIs) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			LoginButton.click();
			
//		}else {
//			System.out.println("Login Button is not enabled");
//		}
		
		
		
	}
	
	public void ActWebEleVAl() {
		
		//Check if  the webElements Displayed in the webPage is activated and user can able to perform actions 
		
		//Click on About
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement AboutLink = driver.findElement(By.xpath("//a[normalize-space()='About']"));
		AboutLink.click();
		
		
		
		
		
	
	


}
}

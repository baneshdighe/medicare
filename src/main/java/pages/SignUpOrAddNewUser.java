package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpOrAddNewUser {

	WebDriver driver;
	
	public SignUpOrAddNewUser(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SignUpButton() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Signup = driver.findElement(By.id("signup"));
		Signup.click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
			//User Give the name in the Name Text Box
			WebElement FirstName = driver.findElement(By.id("firstName"));
			FirstName.clear();
			FirstName.sendKeys("Banesh");
			
			//User give the last Name in the Last Name text box
			WebElement LastName = driver.findElement(By.id("lastName"));
			LastName.clear();
			LastName.sendKeys("Dighe");
			
			//User entered Email Address in the email Text Box
			WebElement Email = driver.findElement(By.id("email"));
			Email.clear();
			Email.sendKeys("baneshdighe112@gmail.com");
			
			//User Entered Contact number in the Contact number Text box 
			WebElement ContactNumber = driver.findElement(By.id("contactNumber"));
			ContactNumber.clear();
			ContactNumber.sendKeys("7769038853");
			
			//User given the Password In the Password TextBox
			WebElement Password = driver.findElement(By.id("password"));
			Password.clear();
			Password.sendKeys("Baneshdighe");
			
			//User Confirm same pasword as given above
			WebElement ConfirmPassword = driver.findElement(By.id("confirmPassword"));
			ConfirmPassword.clear();
			ConfirmPassword.sendKeys("Baneshdighe");
			
			//user click on Role as a User in the Radio Button selector
			
			WebElement Roleradio = driver.findElement(By.id("role1"));
			Roleradio.click();
			
			
			
			
		//}
	}


	
}

package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminHomePage {
	
	WebDriver driver;
	
	public AdminHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ExpPageAuth() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement expectedAdminNameElement = driver.findElement(By.xpath("//a[@id='dropdownMenu1']"));
		WebElement ManageProductLink = driver.findElement(By.id("manageProduct"));
		
		boolean ExpAdminNameField =expectedAdminNameElement.isDisplayed();
		boolean ManageProductLinkD = ManageProductLink.isDisplayed();
		
		if(ExpAdminNameField) {
			
			System.out.println("Expected page is open with the admin name as..."+expectedAdminNameElement.getText());
			
		}else if(ManageProductLinkD) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("Expected page is open with the management link for product as..."+ManageProductLink.getText());
			
		}else {
			System.out.println("Expected page is not opened, the open page url is..."+driver.getCurrentUrl());
		}
	}
	
	public void ManageProducts() {
		
		//Admin clicked on Manage tab 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement Manage = driver.findElement(By.id("manageProduct"));	
		Manage.click();
	
		
		//verify that the Product management panal is visible and admin should be able to perform certain actions on it
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement ProdManagPan = driver.findElement(By.xpath("//div[@class='panel panel-primary']"));
		
		boolean ExpPanel = ProdManagPan.isDisplayed();
		
		if(ExpPanel) {
			//Enter name in Name Field.
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			WebElement ProductNameField = driver.findElement(By.xpath("//input[@placeholder='Product Name']"));
			ProductNameField.clear();
			ProductNameField.sendKeys("New Product 1");
			
			//Enter Brand in Brand name field.
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			WebElement BrandName = driver.findElement(By.xpath("//input[@placeholder='Brand Name']"));
			BrandName.clear();
			BrandName.sendKeys("New Brand 1");
			
			//Enter Description in the Description field.
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Enter your description here!']"));
			Description.clear();
			Description.sendKeys("This is New Product of New Brand and used for ....");
			
			//Enter price in Unit Price field
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			WebElement UnitPrice = driver.findElement(By.id("unitPrice"));
			UnitPrice.clear();
			UnitPrice.sendKeys("10");
			
			//Add quantity in Quantity field
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			WebElement Quantity =driver.findElement(By.xpath("//input[@placeholder='Enter Quantity']"));
			Quantity.clear();
			Quantity.sendKeys("10");
			
			//image add box locator
			WebElement ImageSelBox = driver.findElement(By.id("file"));
			

			//select category of the medicine
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			Select se = new Select (driver.findElement(By.name("categoryId")));
			se.selectByIndex(1);
			
			//Click on save button
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			WebElement SaveButton= driver.findElement(By.xpath("//form[@action='/medicare/manage/product']//div//div//input[@name='submit']"));
			SaveButton.click();
			
			//admin tried to enter medicine details without uploading an appropriate image then Error should be thrown 
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement Error = driver.findElement(By.id("file.errors"));
			System.out.println("The appropriate error is shown ..."+Error.getText());
			
		}else {
			System.out.println("Admin is unable to add Product by admin portal");
		}
	}

}

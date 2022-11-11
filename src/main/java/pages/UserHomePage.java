package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserHomePage {
	
	WebDriver driver;

	
	public UserHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
public void AddToCart() {
		
		//User selects some medicines and added it into the cart
		
		//User should be able to see The most viewed Medicines at the homepage
		
		//User scrolls down till particular elements are found
		
		//Locating element for scroll down method using particular element 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Med1 = driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mvProducts']//img[@alt='Paracetamol']"));
        WebElement Med2 = driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mvProducts']//img[@alt='Aceclofenac']"));
        WebElement Med3 = driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mpProducts']//img[@alt='Paracetamol']"));
        WebElement Med5 = driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mpProducts']//img[@alt='Aceclofenac']"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Med1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        js.executeScript("arguments[0].scrollIntoView();", Med2);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        js.executeScript("arguments[0].scrollIntoView();", Med3);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        js.executeScript("arguments[0].scrollIntoView();", Med5);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		//print available product Description, Price and name in the console
		
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		
		List<WebElement> MostViewMed=(List<WebElement>) driver.findElements(By.className("ng-binding"));
       
		System.out.println("Most Viewed products are...");
        for(int i=0;i<MostViewMed.size();i++){
        	
            System.out.println(MostViewMed.get(i).getText());
        }  
	}
	public void ChooseMed() {
		
		//user click on Paracetamol 
		WebElement ParacPro = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//a[1]"));
		ParacPro.click();
		
		//check if user nevigated to the expected medicine page
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean ExpMed1 = driver.findElement(By.xpath("//p[normalize-space()='An antipyretic medicine used for fever.']")).isDisplayed();
		
		if(ExpMed1) {
			System.out.println("The same product is shown as the user want to see..");
		}else {
			System.out.println("user is not able to see appropriate product");
		}
		
		//User should be able to Add the product into cart
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement AddToCartButton = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		AddToCartButton.click();
		
		//verify that the selected product is added into the cart or not by its name text
		WebElement CartProd = driver.findElement(By.className("nomargin"));
		String CartProdSel = CartProd.getText();
		Assert.assertEquals(CartProdSel, "Paracetamol");
		
		
		
	}
	public void Checkoout() {
		//user click on checkout Button
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement CheckOutButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']"));
		CheckOutButton.click();
		
		
	}
	public void DeliveryPayAddress() {
		//user selects default address
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement AddrBut =driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
//		AddrBut.click();
		
		
	

		WebElement elementToClick = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));



		// Scroll the browser to the element's Y position

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");



		// Click the element

		elementToClick.click();
		
		
		
		
		
		
		//verify that the user is able to navigate payment page
		 driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
		boolean PayButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg btn-block']")).isDisplayed();
		if(PayButton) {
			System.out.println("User is able to select and add a product into the cart and checkout");
			driver.close();
		}else {
			System.out.println("User is not able to perform certain actions on product to add in cart");
	}
	
	}
	
}

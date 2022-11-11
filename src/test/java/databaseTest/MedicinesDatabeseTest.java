package databaseTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;

public class MedicinesDatabeseTest extends Base {
	
	WebDriver driver;
	
	Statement stmt;
	Connection con;
	
	
	
	@Test(priority = 1)
	public void MedicareDataBaseTest() throws IOException, SQLException {
		
		
		try {
		driver = initializeDriver();
		driver.get("http://localhost:8081/medicare/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Set database connection
		  String dbUrl = "jdbc:mysql://127.0.0.1:3306/medicare";     

			 
		  String username = "root"; 
		        
		  String password = "Baneshdighe111@";
		
		 con = DriverManager.getConnection(dbUrl,username,password);
		
		// Statement object to send the SQL statement to the Database
		 stmt = con.createStatement();
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
	
	}@Test(priority = 2)
	public void test() {
		try{
		String query = "select * from product";
		// Get the contents of product table from DB
		ResultSet res = stmt.executeQuery(query);
		// Print the result until all the records are printed
		// res.next() returns true if there is any next record else returns false
		while (res.next())
		{
		System.out.print(res.getString(1));
		System.out.print(" " + res.getString(2));
		System.out.print(" " + res.getString(3));
		System.out.print(" " + res.getString(4));
		System.out.print(" " + res.getString(5));
		System.out.println(" " + res.getString(6));
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
	}@Test(priority =3 )
	public void test2() {
		try{
		String query2 = "select * from address";
		
		ResultSet res1 = stmt.executeQuery(query2);
		
		while (res1.next())
		{
		System.out.println(res1.getString(1));
		
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority =4 )
	public void test3() {
		try{
		String query3 = "select * from cart_line";
		
		ResultSet res2 = stmt.executeQuery(query3);
		
		while (res2.next())
		{
		System.out.println(res2.getString(1));
		
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority =5 )
	public void test4() {
		try{
		String query4 = "select * from category";
		
		ResultSet res3 = stmt.executeQuery(query4);
		
		while (res3.next())
		{
		System.out.print(res3.getString(1));
		System.out.print(" " + res3.getString(2));
		System.out.println(" " + res3.getString(3));
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority =6 )
	public void test5() {
		try{
		String query5 = "select * from user_detail";
		// Get the contents of product table from DB
		ResultSet res4 = stmt.executeQuery(query5);
		
		while (res4.next())
		{
		System.out.print(res4.getString(1));
		System.out.print(" " + res4.getString(2));
		System.out.print(" " + res4.getString(3));
		System.out.println(" " + res4.getString(4));
		}
	}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority = 7)
	public void test7() throws SQLException {
		
		//Update Name of the medicine in database and see if same is updated and displayed in UI or not
		
		String ParaBeforeChane =driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mvProducts']//h5[@class='ng-binding'][normalize-space()='Paracetamol']")).getText();
		System.out.println("Name of the medicine before change in database  = "+ParaBeforeChane);
		
		String query6 = "UPDATE product SET name='Paracetamol plus' WHERE id='1';";
		
		
		
		
		int res5 = stmt.executeUpdate(query6);
		
		
		
		
		
		driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebElement ParaChange =driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mvProducts']//h5[@class='ng-binding'][normalize-space()='Paracetamol plus']"));
		boolean ChangeName = driver.findElement(By.xpath("//div[@ng-repeat='product in pCtrl.mvProducts']//h5[@class='ng-binding'][normalize-space()='Paracetamol plus']")).isDisplayed();
		if(ChangeName) {
			System.out.println("updated name showing of the medicine in UI is = "+ParaChange.getText());
		}
		
		
		
	}

		@AfterTest
		public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
		con.close();
		driver.close();
		}
	}
}
		
		
	
	



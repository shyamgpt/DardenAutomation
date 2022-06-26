package com.darden.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DardenTest {
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.olivegarden.com/menu");
		 driver.manage().window().maximize();
		
	}
	
	@Test
	public void locationSelectionTest() throws InterruptedException {
		
		 driver.findElement(By.xpath("//input[@placeholder='Enter city & state or zipcode']")).sendKeys("Orl");
		 driver.findElement(By.xpath("//div[contains(text(),'Orlando, FL, United States')]")).click(); 
		// Thread.sleep(3000);
		 driver.findElement(By.xpath("(//div[@aria-label='Order Online for ORDER ONLINE location'])[1]")).click();
		String restaurantName = driver.findElement(By.xpath("(//div[contains(text(),'Orlando - Fashion Square')])[1]")).getText();
		System.out.println(restaurantName);
		Assert.assertEquals("Orlando - Fashion Square",restaurantName );
	}
	


}

package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderSample {
	@Test(dataProvider = "Test01",priority=-1)
	private void facebook(String name,String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys(name);
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(password);

	}
	
	@DataProvider(name = "Test01")
	private Object[][] getData() {
		return new Object[][] {
			{"test01","test01@123"},{"test02","test02@123"}};
			
			
		}
	@Test(dataProvider = "Test03",dataProviderClass =  DataProviderClassSample.class,priority=1,invocationCount = 2)
	
	private void facebook1(String name,String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys(name);
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(password);

	}
	

	}



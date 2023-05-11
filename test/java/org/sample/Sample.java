package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	@Parameters({"mail","passw"})
	@Test
	private void test(@Optional ("kish")String name,@Optional("kish")String password) {
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

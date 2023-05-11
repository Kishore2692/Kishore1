package org.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {
	@Parameters({"fromCity","toCity"})
	@Test
	private void blaze(String fromCity,String toCity) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://blazedemo.com/");
		driver.findElement(By.xpath("//a[contains(text(),'The Beach')]")).click();
		String actVacation = driver.getTitle();
				System.out.println(actVacation);
		boolean contains = actVacation.contains("vacation");
		Assert.assertTrue(contains);
		driver.navigate().back();
		WebElement ddnFromCity = driver.findElement(By.name("fromPort"));
		Select fromSelect = new Select(ddnFromCity);
		fromSelect.selectByVisibleText(fromCity);
		WebElement ddnToCity = driver.findElement(By.name("toPort"));
		Select toSelect = new Select(ddnToCity);
		toSelect.selectByVisibleText(toCity);
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		List<WebElement> flightPriceAll = driver.findElements(By.xpath("//tr//td[6]"));
		List<String> price1 = new ArrayList<>();
		for(WebElement flightPrice:flightPriceAll) {
			String price = flightPrice.getText().replace("$", "");
			price1.add(price);
		}
		System.out.println(price1);
		Collections.sort(price1);
		String PriceMin = price1.get(0);
		driver.findElement(By.xpath("//td[contains(text(),'"+PriceMin+"')]/preceding-sibling::td/child::input[@value='Choose This Flight']")).click();
		String totalPrice = driver.findElement(By.tagName("em")).getText();
		System.out.println(totalPrice);
		 
	 
	}

}

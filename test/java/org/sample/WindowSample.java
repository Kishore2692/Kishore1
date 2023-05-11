package org.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSample {
@Test
private void emthis() {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://nxtgenaiacademy.com/multiplewindows/");
WebElement btnNewTab = driver.findElement(By.xpath("(//button[@id='button1'])[3]"));

for(int i=0;i<=2;i++) {
	btnNewTab.click();
}
String parId = driver.getWindowHandle();
Set<String> allId = driver.getWindowHandles();
System.out.println(allId);

List<String> l = new ArrayList<String>(allId);

driver.switchTo().window(l.get(1));
System.out.println(l.get(1));
//driver.switchTo().defaultContent();
}

}

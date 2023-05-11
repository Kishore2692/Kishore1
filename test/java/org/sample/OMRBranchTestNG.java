package org.sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OMRBranchTestNG extends BaseClass {

	static WebDriver driver;
	static String res;

	@BeforeClass
	public void browserLaunch() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public static void hotelBooking() throws InterruptedException {

		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("kishorebabu2692@gmail.com");

		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("Omrbranch@123");

		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement txtLoginSuccess = driver.findElement(By.xpath("//a[@data-testid='username']"));
		String welcomeMsg = txtLoginSuccess.getText().trim();
		System.out.println(welcomeMsg);
		Assert.assertEquals("Welcome Kishore", welcomeMsg);
		
		driver.findElement(By.xpath("//h3[text()='Hotel Booking']")).click();

		driver.switchTo().frame("hotelsearch_iframe");

		driver.findElement(By.id("searchBtn")).click();
		
		driver.switchTo().defaultContent();

		List<WebElement> actErrorMsg = driver.findElements(By.xpath("//div[contains(text(),'Please select')]"));
		List<String> actError = new ArrayList<String>();
		for (WebElement errorMsg : actErrorMsg) {
			String actMsg = errorMsg.getText();
			actError.add(actMsg);
		}
System.out.println(actError);
	}

	@Test(priority = 2)
	
	public void searchHotel() {

		WebElement ddnState = driver.findElement(By.id("state"));
		Select ddnSelectState = new Select(ddnState);
		ddnSelectState.selectByVisibleText("Andhra Pradesh");

		WebElement ddnCity = driver.findElement(By.id("city"));
		Select ddnSelectCity = new Select(ddnCity);
		ddnSelectCity.selectByValue("Tirupati");

		WebElement ddnSelectRoomType = driver.findElement(By.id("room_type"));
		Select ddnRoomType = new Select(ddnSelectRoomType);
		ddnRoomType.selectByValue("Standard");
		ddnRoomType.selectByValue("Deluxe");
		ddnRoomType.selectByValue("Suite");

		WebElement txtCheckInDate = driver.findElement(By.name("check_in"));

		String currentDate = currentDate("yyyy/MM/dd");

		txtCheckInDate.sendKeys(currentDate, Keys.ENTER);

		Date date = new Date();
//		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		
//		String format = dateFormat.format(date);
//		
//		txtCheckInDate.sendKeys(format,Keys.ENTER);

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		js.executeScript("arguments[0].setAttribute('value','2023-03-21')", txtCheckInDate);

		WebElement txtCheckOut = driver.findElement(By.name("check_out"));

//		String format1 = dateFormat.format(date);

		String currentDate2 = currentDate(currentDate);

		txtCheckOut.sendKeys(currentDate2, Keys.ENTER);

//		js.executeScript("arguments[0].setAttribute('value','2023-03-23')", txtCheckOut);

		WebElement ddnSelectRooms = driver.findElement(By.id("no_rooms"));
		Select ddnRoomNos = new Select(ddnSelectRooms);
		ddnRoomNos.selectByVisibleText("1-One");

		WebElement ddnAdults = driver.findElement(By.id("no_adults"));
		Select ddnAdultPerRoom = new Select(ddnAdults);
		ddnAdultPerRoom.selectByVisibleText("2-Two");

		driver.findElement(By.id("no_child")).sendKeys("2");

//		WebElement frame = driver.findElement(By.id("hotelsearch_iframe"));
		driver.switchTo().frame("hotelsearch_iframe");

		driver.findElement(By.id("searchBtn")).click();

		WebElement successMsgSelectHotel = driver.findElement(By.xpath("//div[@class='row explore-hotels']//h5"));
		String act = successMsgSelectHotel.getText();
		System.out.println(act);
		Assert.assertEquals("Select Hotel", act);
	}

	@Test(priority=3)
	

	public void SelectHotel() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//a[@class='btn filter_btn'])[1]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().alert().accept();
	}
	@Test(priority=4)
		
		private void bookHotel() throws InterruptedException {
		

		WebElement findElement = driver.findElement(By.xpath("//h2[contains(text(),'Book Hotel')]"));
		String string = findElement.getText().substring(0, 10);
		System.out.println(string);

		Thread.sleep(3000);

//		driver.findElement(By.id("own")).click();
//
//		WebElement ddnSalutation = driver.findElement(By.id("user_title"));
//		Select salutation = new Select(ddnSalutation);
//		salutation.selectByValue("Mr");
//
//		driver.findElement(By.id("first_name")).sendKeys("Kishore");
//
//		driver.findElement(By.id("last_name")).sendKeys("Babu");
//
//		driver.findElement(By.id("user_phone")).sendKeys("9789965990");
//
//		driver.findElement(By.id("user_email")).sendKeys("kishorebabu2692@gmail.com");
//
//		driver.findElement(By.id("gst")).click();
//
//		driver.findElement(By.id("gst_registration")).sendKeys("9043592058");
//
//		driver.findElement(By.id("company_name")).sendKeys("Greens Tech OMR Branch");
//
//		driver.findElement(By.id("company_address")).sendKeys("Thoraipakkam");
//
//		driver.findElement(By.id("step1next")).click();
//
//		driver.findElement(By.id("early")).click();
//
//		driver.findElement(By.id("bed")).click();
//
//		driver.findElement(By.id("other_request")).sendKeys("Nothing");
//
//		driver.findElement(By.id("step2next")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
//		driver.findElement(By.xpath("//div[@class='credit-card pm']")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		WebElement ddnPaymentType = driver.findElement(By.id("payment_type"));
//		Select paymentType = new Select(ddnPaymentType);
//		paymentType.selectByValue("debit_card");
//
//		WebElement ddnCardType = driver.findElement(By.id("card_type"));
//		Select cardType = new Select(ddnCardType);
//		cardType.selectByValue("visa");
//
//		driver.findElement(By.id("card_no")).sendKeys("5555555555552222");
//
//		driver.findElement(By.id("card_name")).sendKeys("Kishorebabu");
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		WebElement ddnCardMonth = driver.findElement(By.id("card_month"));
//		Select cardMonth = new Select(ddnCardMonth);
//		cardMonth.selectByValue("01");
//
//		WebElement ddnCardYear = driver.findElement(By.id("card_year"));
//		Select cardYear = new Select(ddnCardYear);
//		cardYear.selectByValue("2026");
//
//		driver.findElement(By.id("cvv")).sendKeys("123");
//
//		driver.findElement(By.id("submitBtn")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		WebElement bookingId = driver.findElement(By.xpath("//strong"));
//		res = bookingId.getText().replace("#", "");
//		System.out.println(res);
//
//		return;
	}

	@Test(priority = 2)
	@Ignore

	private void cancelBooking() throws InterruptedException {

		Thread.sleep(5000);

		WebElement btnMyBooking = driver.findElement(By.xpath("//button[text()='My Booking']"));
		btnMyBooking.click();

		driver.findElement(By.name("search")).sendKeys(res);

		driver.findElement(By.xpath("//a[text()='Cancel']")).click();

		driver.switchTo().alert().accept();

		System.out
				.println(driver.findElement(By.xpath("//li[text()='Your booking cancelled successfully']")).getText());

		Thread.sleep(3000);

	}

	@Test(priority = 3)
	@Ignore
	private void editBooking() throws InterruptedException {

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='My Booking']")).click();

		driver.findElement(By.name("search")).sendKeys(res);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='Edit']")).click();

		WebElement checkInDate = driver.findElement(By.name("check_in"));
		checkInDate.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click('value',23)", checkInDate);

		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		System.out.println(driver.findElement(By.xpath("//li[text()='Booking updated successfully']")).getText());

	}
}

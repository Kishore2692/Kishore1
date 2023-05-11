package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Kishorebabu
 * @Date 22-03-2023
 * @See Used to maintain the reusable method
 *
 */


public class BaseClass {
	public static WebDriver driver;
	
	/**
	 * 
	 * @return String
	 * @see To get the access till project location
	 */
	public static String getProjectPath() {

		String path = System.getProperty("user.dir");
		return path;
	}
	
/**
 * 
 * @param key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 * @see To get the values from property file
 */
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	
	public void setPropertyFile(String key, String value) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		
		properties.setProperty(key, value);
		
		FileOutputStream fileOutputStream = new FileOutputStream(getProjectPath()+"\\Config\\hotel.properties");
		
		

	}
/**
 * 
 * @param browserType
 * @see To launch the browser
 */
	
	
	public static void getDriver(String browserType) {
		
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}
/**
 * 
 * @param url
 * @see To enter application url
 */
	public static void enterAppUrl(String url) {
		driver.get(url);
	}
/**
 * @see To maximixe the window
 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
/**
 * 
 * @param element
 * @param data
 * @see To pass the data in textBox
 */
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
/**
 * 
 * @param element
 * @see To click the WebElement
 */
	public void elementClick(WebElement element) {
		element.click();
	}
/**
 * 
 * @return String
 * @see To get the application title
 */
	public String getApplTitle() {
		String title = driver.getTitle();
		return title;
	}
/**
 * 
 * @param attributeValue
 * @return Webelement
 * @see To find the webElement by ID
 */
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
/**
 * 
 * @param attributeValue
 * @return WebElement
 * @see To find the webElement by Name
 */
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
/**
 * 
 * @param attributeValue
 * @return WebElement
 * @see To find the webElement by className
 */
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
/**
 * 
 * @param xpathExp
 * @return WebElement
 * @see To find the webElement by xpath
 */
	public WebElement findElementByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}
/**
 * 
 * @param tagName
 * @return WebElement
 * @see To find the webElement by tagName
 */
	public WebElement findElementByTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}
/**
 * 
 * @return String
 * @see To get the current application page Url
 */
	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
/**
 * 
 * @param element
 * @return 
@see To get the application page text
 */
	public static String getApplnText(WebElement element) {
		String text = element.getText();
		return text;
	}
/**
 * 
 * @param element
 * @return String
 * @see To get the attribute value from the application page
 */
	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
/**
 * 
 * @param element
 * @param attribute
 * @return String
 * @see To get the attribute value by passing the attribute name from the application page
 */
	public String elementGetAttribute(WebElement element, String attribute) {
		String attribute1 = element.getAttribute(attribute);
		return attribute1;
	}
/**
 * 
 * @param element
 * @param text
 * @see To select the value in dropdown using visible text
 */
	public void selectOptionByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}
/**
 * 
 * @param element
 * @param attributeValue
 * @see To select the value in dropdown using value
 */
	public void selectOptionByValue(WebElement element, String attributeValue) {
		new Select(element).selectByValue(attributeValue);
	}
/**
 * 
 * @param element
 * @param Index
 * @see To select the value in dropdown using Index
 */
	public void selectOptionByIndex(WebElement element, int Index) {
		new Select(element).selectByIndex(Index);
	}
/**
 * 
 * @param element
 * @param text
 * @see To pass the data in textBox using JavaScript
 */
	public void elementSendKeysJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}
/**
 * 
 * @see To accept the alert
 */
	public static void accept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
/**
 *@see To dismiss the alert
 */
	public void dismiss() {
		driver.switchTo().alert().dismiss();
	}
/**
 * @see To pass the value in alert text box
 */
	public void sendKeysAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}
/**
 * @see To close all windows
 */
	public void closeAllWindows() {
		driver.quit();
	}
/**
 * @see To close the current window
 */
	public static void closeCurrentWindow() {
		driver.close();
	}
/**
 * 
 * @param element
 * @see To click the webElement using Javascript
 */
	public void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
/**
 * 
 * @param element
 * @see To get the attribute value using Javascript
 */
	public void getAttributeJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("returnarguments[0].getAttribute('value')", element);
	}
/**
 * 
 * @param element
 * @return List<WebElement>
 * @see To select all options in dropdown
 */
	public List<WebElement> getAllSelectOptions(WebElement element) {
		List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
		return allSelectedOptions;
	}
/**
 * 
 * @param element
 * @return List<WebElement>
 * @see To get the selected options from dropdown
 */
	public List<WebElement> getOptions(WebElement element) {
		List<WebElement> options = new Select(element).getOptions();
		return options;
	}
/**
 * 
 * @param element
 * @return WebElement
 * @see To get the first selected options from dropdown
 */
	public WebElement getFirstSelectedOptions(WebElement element) {
		WebElement firstSelectedOption = new Select(element).getFirstSelectedOption();
		return firstSelectedOption;
	}
/**
 * 
 * @param element
 * @return boolean
 * @see To find multiple options can select in dropdown
 */
	public boolean isMultiple(WebElement element) {
		boolean multiple = new Select(element).isMultiple();
		return multiple;
	}
/**
 * 
 * @param element
 * @param index
 * @see To deselect the options in dropdown using Index
 */
	public void deSelectByIndex(WebElement element, int index) {
		new Select(element).deselectByIndex(index);
	}
/**
 * 
 * @param element
 * @param attributeValue
 * @see To deselect the options in dropdown using value
 */
	public void deSelectByValue(WebElement element, String attributeValue) {
		new Select(element).deselectByValue(attributeValue);
	}
/**
 * 
 * @param element
 * @param text
 * @see To deselect the options in dropdown using visible text
 */
	public void deSelectByVisibleText(WebElement element, String text) {
		new Select(element).deselectByVisibleText(text);
	}
/**
 * 
 * @param element
 * @see To deselect all options in dropdown
 */
	public void deSelectAll(WebElement element) {
		new Select(element).deselectAll();
	}
/**
 * 
 * @return String
 * @see To get parent window ID
 */
	public String getParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
/**
 * 
 * @return Set<String>
 * @see To get all window ID
 */
	public Set<String> getAllWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
/**
 * 
 * @param attributeValue
 * @see To switch frame using ID
 */
	public void switchToFrameById(String attributeValue) {
		driver.switchTo().frame(attributeValue);
	}
/**
 * 
 * @param attributeValue
 * @see To switch frame using name
 */
	public void switchToFrameByName(String attributeValue) {
		driver.switchTo().frame(attributeValue);
	}
/**
 * 
 * @param element
 * @see To switch frame using WebElement
 */
	public void switchToFrameByWebElementElement(WebElement element) {
//		WebElement element = driver.findElement(By.xpath(frame));
		driver.switchTo().frame(element);

	}
	
	public void defaultFrame() {
driver.switchTo().defaultContent();
	}
/**
 * 
 * @param index
 * @see To switch frame using Index
 */
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
/**
 * 
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return String
 * @throws IOException
 * @see To read data from the excel sheet
 */
	public String readCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		String res = null;
		File file = new File("D:\\Eclipse\\TestMaven\\Excel\\Adactin1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (numericCellValue == check) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
			break;
		default:
			break;
		}
		return res;
	}
/**
 * 
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param oldData
 * @param newData
 * @throws IOException
 * @see To update data in excel sheet
 */
	public void updateCellData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File("D:\\Eclipse\\TestMaven\\Excel\\Adactin1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value == oldData) {
			cell.setCellValue(newData);
		}
		FileOutputStream outPutStream = new FileOutputStream(file);
		workbook.write(outPutStream);
	}
/**
 * 
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param newData
 * @throws IOException
 * @see To write data in the excel sheet
 */
	public void writeCellData(String sheetName, int rowNum, int cellNum, String newData) throws IOException {
		File file = new File("D:\\Eclipse\\TestMaven\\Excel\\Adactin1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(newData);

		FileOutputStream outPutStream = new FileOutputStream(file);
		workbook.write(outPutStream);
	}
/**
 * 
 * @param dateCheckIn
 * @see To clear the exisiting data from the textbox
 */
	public static void elementClear(WebElement dateCheckIn) {
		dateCheckIn.clear();
	}
/**
 * 
 * @param path
 * @throws IOException
 * @see To takesscreenshot 
 */
	public static void takesScreenShot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);

	}
/**
 * @see To find the times takes to execute the method
 */
	public static void timesTakes() {
		long time = System.currentTimeMillis();
		System.out.println(time);

	}
/**
 * 
 * @param format
 * @return Date
 * @see To get the current date
 */
	public String currentDate(String format) {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String format2 = dateFormat.format(date);
		return format2;

	}
/**
 * @see To click the enter key using actions
 */
	public void enter() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ENTER).perform();
		actions.keyUp(Keys.ENTER).perform();

	}
	public void implicit(long seconds) {
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

}
	
	public void splitText(WebElement element,String text) {
		
		
		String[] split = text.split("/");
		for (int i = 0; i < split.length; i++) {
			selectOptionByVisibleText(element, split[i]);
		}
		
		}
	
	public void elementSendKeysWithEnter(WebElement element,String text) {
	element.sendKeys(text,Keys.ENTER);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
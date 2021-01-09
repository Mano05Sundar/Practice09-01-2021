package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Element;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// chromeBrowserLaunch
	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// firefoxBrowserLaunch
	public static void launchFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	// internetExplorerLaunch
	public static void launchInternetExplorer() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	// browserLaunch
	public static void launchBrowser(String browserNameWithinDoubleQuotes) {
		if (browserNameWithinDoubleQuotes.equalsIgnoreCase("Google")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserNameWithinDoubleQuotes.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
		} else if (browserNameWithinDoubleQuotes.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}

	// launchURL
	public static void launchURL(String url) {
		driver.get(url);
	}

	// quit browser
	public static void quitBrowser() {
		driver.quit();
	}

	// close browser
	public static void closebrowser() {
		driver.close();
	}

	// sendKeys
	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	// getText
	public static String getText(WebElement element) {
		String text = element.getText();

		System.out.println(text);
		return text;
	}

	// getAttribute
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// TakeScreenShot method
	// 1.getScreenShotAs
	public static void getScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\mano0\\Sundar\\BaseClass_FunctionalLibrary_LibGlobal_UtilityClass\\Screenshots\\Screenshot1.png");
		FileUtils.copyFile(source, destination);
	}

	// JavascriptExecutor methods
	// 1.setAttribute
	public static void SetAttributeJS(WebElement element, String valueToSetAttribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', 'valueToSetAttribute')", element);
	}

	// 2.getAttribute
	public static void getAttributeJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object object = js.executeScript("returnarguments[0].getAttribute('value')", element);
		String text = (String) object;
		System.out.println(text);
	}

	// 3.scrollUp
	public static void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}

	// 4.scrollDown
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);
	}

	// 5.highLight
	public static void highLight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:lightgreen;border:solidgreen')", element);
	}

	// Actions methods
	// 1.mouseOverAction
	public static void mouseOverAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	// 2.mouseDragAndDrop
	public static void DragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions a = new Actions(driver);
		a.dragAndDrop(sourceElement, targetElement).perform();
	}

	// 3.mouseDoubleClick
	public static void mouseDoubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	// 4.mouseRightClick
	public static void mouseRightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	// 5.release
	public static void release(WebElement element) {
		Actions a = new Actions(driver);
		a.release(element).perform();
		;

	}

	// Alert methods
	// 1.alertAccept
	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 2.alertDismiss
	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 3. alertSendKeys
	public static void alertSendKeys(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
	}

	// 4. alertGetText
	public static void alertGetText() {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		System.out.println(text);
	}

	// Select methods
	// 1.selectByValue
	public static void selectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 2.deselectByValue
	public static void deselectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	// 3.selectByVisibleText
	public static void selectVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// 4.deselectByVisibleText
	public static void deselectVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	// 5.selectByIndex
	public static void selectIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// 6.deselectByIndex
	public static void deselectIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	// 7.getFirstSelectedOption
	public static void getFirstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);

	}

	// 8.getAllSelectedOptions
	public static void getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			String text = allSelectedOptions.get(i).getText();
			System.out.println(text);

		}
	}

	// 9.deselectAll
	public static void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	// 11.getOptions
	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
	}

	// 12.isMultiple
	public static void name(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// getTagName
	public static void getTagName(WebElement element) {
		String tagName = element.getTagName();
		System.out.println(tagName);
	}

	// maximizeBrowser
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	// cleanText
	public static void cleanText(WebElement element) {
		element.clear();
	}

	// click
	public static void click(WebElement element) {
		element.click();
	}

	// refresh
	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void forward() {
		driver.navigate().forward();

	}

	public static void back() {
		driver.navigate().back();

	}

	public static void launchByNavigate(String data) {
		driver.navigate().to(data);

	}

	// data driven(DDD)
	public static String readExcel(String path, String sheetName, int rowNo, int cellNo) throws IOException {

		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = "";
		int cellType = cell.getCellType();
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
			value = format.format(dateCellValue);

		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}

		return value;

	}

	public static void writeExcel(String loc, int row, int cell, String value)
			throws IOException, InvalidFormatException {

		File f = new File(loc);
		FileInputStream inputStream = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(inputStream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		FileOutputStream outputStream = new FileOutputStream(f);
		w.write(outputStream);

	}
}

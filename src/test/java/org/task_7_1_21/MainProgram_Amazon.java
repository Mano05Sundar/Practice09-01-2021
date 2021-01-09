package org.task_7_1_21;

import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.baseClass.BaseClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainProgram_Amazon extends BaseClass {

	@BeforeClass
	public void launchBrowser() {
		launchChromeBrowser();
		maximizeBrowser();
	}

	@BeforeMethod
	public void startTime() {
		// import util.date package
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void test() throws IOException {

		launchURL("https://www.amazon.in/");
		Pojo1_AmazonHomePage a = new Pojo1_AmazonHomePage();
		sendKeys(a.getSearchField(),
				readExcel("C:\\Users\\mano0\\Sundar\\Task_7_1_21\\Workbook\\AmazonDetails.xlsx", "Sheet1", 1, 0));
		click(a.getSearchButton());
		getText(a.getFirstProduct());

		// to print all the titles from the amazon page
		List<WebElement> titles = a.getTitles();
		for (WebElement webElement : titles) {
			String text = webElement.getText();
			System.out.println(text);

		}
		// to print all the price list and converting list into set, for removing
		// duplicates
		Set<String> price = new HashSet<String>();
		List<WebElement> priceList = a.getPriceList();
		for (int i = 0; i < priceList.size(); i++) {
			WebElement webElement = priceList.get(i);
			String text = webElement.getText();
			System.out.println(text);
			price.add(text);
		}
		// to find no of duplicate prices
		int a1 = priceList.size() - price.size();
		System.err.println("duplicate price counts " + a1);

		// to convert string to integer// to remove comma// to print price between 50k
		// and 85k
		for (String s : price) {
			String replace = s.replace(",", "");
			int priceint = Integer.parseInt(replace);
			if ((priceint > 50000) && (priceint < 85000)) {
				System.out.println(priceint);
			}
		}
	}

	@AfterMethod
	public void endTime() {
		Date date = new Date();
		System.out.println(date);
	}

	@AfterClass
	public void closeBrowser() {
		closebrowser();
	}
}

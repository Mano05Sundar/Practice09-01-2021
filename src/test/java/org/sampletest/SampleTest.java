package org.sampletest;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	WebDriver driver;

	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@BeforeMethod
	private void beforeMethod() {
		Date date = new Date();
		System.out.println(date);

	}

	@Test(parameters = { "username", "password" })
	private void testMethod(String s, String s1) {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys(s);
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(s1);
		driver.findElement(By.name("login")).click();
		WebElement txtUserName2 = driver.findElement(By.id("email"));
		txtUserName.sendKeys(s);
		WebElement txtPassword2 = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(s1);
		driver.findElement(By.name("login")).click();
		
	}
	@AfterMethod
	private void afterMethod() {
		Date date = new Date();
		System.out.println(date);
		

	}

}

package org.task_7_1_21;

import java.util.List;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo1_AmazonHomePage extends BaseClass {
	public Pojo1_AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;
	@FindBy(xpath = "//span[text()='New Apple iPhone 11 (64GB) - Black']")
	private WebElement firstProduct;
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> titles;
	@FindBy(xpath="//span[@class='a-price-whole']")
	private List<WebElement> priceList;

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	public List<WebElement> getTitles() {
		return titles;
	}

	public List<WebElement> getPriceList() {
		return priceList;
	}

	
}
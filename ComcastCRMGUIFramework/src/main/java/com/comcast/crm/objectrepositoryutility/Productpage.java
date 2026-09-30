package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage { 
	
	WebDriver driver;
	public Productpage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search_field")
	private WebElement SearchDD;
	
	
	@FindBy(name = "submit")
	private WebElement searchbtn;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return SearchDD;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createNewProduct;
	
	
	public WebElement getCreateNewProduct() {
		return createNewProduct;
	}
	
	
	
}


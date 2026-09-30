package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headermsg;
	
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;
	
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeInfo;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneInfo;
	
	public WebElement getPhoneInfo() {
		return phoneInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getHeadermsg() {
		return headermsg;
	}
}

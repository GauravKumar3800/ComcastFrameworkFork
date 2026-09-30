package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author SaiBhanuprakash
 * 
 * Contains Login page elements & bussiness lib like login()
 * 
 */
public class LoginPage extends WebDriverUtility {
	// Rule-1 Create a separate java class
	// Rule-2 Object Creation 
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Rule-3 object Intialization
    // Rule-4 Object Encapsulation 

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 * login to application based username, password, url arguments
 * @param url
 * @param username
 * @param password
 */
	// Rule-5 provide Action 
	public void loginToapp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}
	
	public void loginToapp(String username, String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}
	
	
	
	

}

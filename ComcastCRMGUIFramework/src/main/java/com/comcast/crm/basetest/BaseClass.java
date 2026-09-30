package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	/* create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	
	@BeforeSuite(groups = { "smokeTest", "RegressionTest" })
	public void configBS() throws SQLException {
		System.out.println("===Connect to DB, Report Config===");
		dbLib.getDbconnection();
	}
	@BeforeClass(groups = { "smokeTest", "RegressionTest" })
	public void configBC() throws Throwable {

		System.out.println("==Launch the Browser==");

		// String BROWSER = flib.getDataFromPropertiesFile("browser");
		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();

		} else {

			driver = new ChromeDriver();

		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod(groups = { "smokeTest", "RegressionTest" })
	public void configBM() throws Throwable {
		System.out.println("=login=");
		/*String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password"); */
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",flib.getDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "RegressionTest" })
	public void configAM() {
		System.out.println("=logout=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "RegressionTest" })
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "RegressionTest" })
	public void configAS() throws SQLException {
		System.out.println("===close Db, Report backUP===");
		dbLib.closeDbconnection();
		
	}

}

package com.comcast.crm.orgtest;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		   /* create Object */ 
	       FileUtility flib = new FileUtility();
	       ExcelUtility elib = new ExcelUtility();
	       JavaUtility jlib = new JavaUtility();
	       WebDriverUtility wlib = new WebDriverUtility();
	   
	       String BROWSER = flib.getDataFromPropertiesFile("browser");
	       String URL = flib.getDataFromPropertiesFile("url");
	       String USERNAME = flib.getDataFromPropertiesFile("username");
	       String PASSWORD = flib.getDataFromPropertiesFile("password");
	       
	       // read testScript data from excelFile
		   String orgName = elib.getDataFromExcel("org", 10, 2) + jlib.getRandomNumber();


		    WebDriver driver = null;
		    if(BROWSER.equals("chrome")) {
		    	driver = new ChromeDriver();
		    } else if(BROWSER.equals("firefox")) {
		    	driver = new FirefoxDriver();
		    } else if(BROWSER.equals("edge")) {
		    	driver = new EdgeDriver();
		    } else {
		    	driver = new ChromeDriver();
		    }

		    // Step 1 : Login
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    driver.get(URL);
		    
		    LoginPage lp = new LoginPage(driver);
		    
		    lp.loginToapp(USERNAME, PASSWORD);
		    
		    // Step 2 : navigate to organization module
		    HomePage hp = new HomePage(driver);
		    hp.getOrgLink().click();

		    // Step 3 : click on "create Organization" Button
		    OrganizationsPage cnp = new OrganizationsPage(driver);
		    cnp.getCreateNewOrgBtn().click();

		    // Step 4 : enter all the details & create new organization
		    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		    cnop.createOrg(orgName);
		    
		    // verify Header msg Expected Result
		    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		    String actOrgName = oip.getHeadermsg().getText();
		    if(actOrgName.contains(orgName)) {
		    	System.out.println(orgName + " name is verified==PASS");
		    } else {
		    	System.out.println(orgName + " name is not verified==FAIL");
		    }
		    
		    // go back to Organization page 
		    hp.getOrgLink().click();
		    
		    // search for Organization 
		    cnp.getSearchEdt().sendKeys(orgName);
		    wlib.select(cnp.getSearchDD(), "Organization Name");
		    cnp.getSearchbtn().click();
		    
		    
		    // In dynamic webtable select & delete org 
		    driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		    
		    wlib.switchtoAlertAndAccept(driver);
		    
		    // Step5 : Logout
		    hp.logout();
		    
		    driver.quit();

	}

}

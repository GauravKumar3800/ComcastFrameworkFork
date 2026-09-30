package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
public class CreateContactWithOrgTest extends BaseClass {
    @Test(groups = "RegressionTest")
	public void createContactWithOrgTest() throws Throwable {
	        // read testScript data from excelFile
	        String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		    String contactLastName = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();

		    // Step 2 : navigate to organization module
		    driver.findElement(By.linkText("Organizations")).click();

		    // Step 3 : click on "create Organization" Button
		    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		    // Step 4 : enter all the details & create new organization
		    driver.findElement(By.name("accountname")).sendKeys(orgName);
		    
		    
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    // verify Header msg Expected Result
		    String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    if(headerInfo.contains(orgName)) {
		    	System.out.println(orgName + " header verified==PASS");
		    } else {
		    	System.out.println(orgName + " header is not verified==FAIL");
		    }
		    // Step 5 : navigate to Contact module
		    driver.findElement(By.linkText("Contacts")).click();
		    

		    // Step 6 : click on "create Contact" Button
		    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		    

		    // Step 7 : enter all the details & create new Contact
		    driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		    wlib.switchToTabOnURL(driver, "module=Accounts");
		    driver.findElement(By.name("search_text")).sendKeys(orgName);
		    driver.findElement(By.name("search")).click();
		    driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		    
		    // Switch to parent Window 
		    wlib.switchToTabOnURL(driver, "Contacts&action");
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    // verify Header LastName info Expected Result
		    headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    if(headerInfo.contains(contactLastName)) {
		    	System.out.println(contactLastName + " header verified==PASS");
		    } else {
		    	System.out.println(contactLastName + " header is not verified==FAIL");
		    }
		    // verify Header orgName info Expected Result
		    String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		    System.out.println(actOrgName);
		    if(actOrgName.trim().equals(orgName)) {
		    	System.out.println(orgName + " information  is created==PASS");
		    } else {
		    	System.out.println(orgName + " information is not created==FAIL");
		    }

	}

}

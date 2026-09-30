package com.comcast.crm.contacttest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.comcast.crm.basetest.BaseClass;

/**
 * @author SaiBhanuprakash
 * 
 * 
 */
public class CreateContactTest extends BaseClass{
	
	     @Test(groups = "smokeTest")
	     public void createContactTest() throws Throwable {
			 
            // read testScript data from excelFile
			String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

			
			// Step 2 : navigate to Contact module
		    driver.findElement(By.linkText("Contacts")).click();
		    
		    
		    // Step 3 : click on "create Contact" Button
		    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		    // Step 4 : enter all the details & create new Contact
		    driver.findElement(By.name("lastname")).sendKeys(lastName);
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    
		    // verify Header LastName info Expected Result
		    String actHeader = driver.findElement(By.className("dvHeaderText")).getText();
		    boolean status = actHeader.contains(lastName);
		    Assert.assertEquals(status, true);
		    
		    String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		    SoftAssert soft = new SoftAssert();
		    soft.assertEquals(actLastName, lastName);
		    soft.assertAll();
	}
}

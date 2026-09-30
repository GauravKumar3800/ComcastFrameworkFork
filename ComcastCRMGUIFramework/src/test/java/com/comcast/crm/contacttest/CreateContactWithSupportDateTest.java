package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;

public class CreateContactWithSupportDateTest extends BaseClass {
	@Test(groups = "RegressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		// read testScript data from excelFile
		String lastName = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();

		// Step 2 : navigate to Contact module
		driver.findElement(By.linkText("Contacts")).click();

		// Step 3 : click on "create Contact" Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 4 : enter all the details & create new Contact

		String StartDate = jlib.getSystemDateYYYDDMM();
		String EndDate = jlib.getRequiredDateYYYYDDMM(30);

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(StartDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(EndDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header StartDate info Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(StartDate)) {
			System.out.println(StartDate + " information is verified==PASS");
		} else {
			System.out.println(StartDate + " information is not verified==FAIL");
		}

		// Verify Header StartDate info Expected Result
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(EndDate)) {
			System.out.println(EndDate + " information is verified==PASS");
		} else {
			System.out.println(EndDate + " information is not verified==FAIL");
		}
	}
}

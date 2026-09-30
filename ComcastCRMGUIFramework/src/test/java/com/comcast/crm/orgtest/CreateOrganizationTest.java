package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;



@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {	
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		
		// read testScript data from excelFile
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();

		// Step 2 : navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org Page");
		
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4 : enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===>Create a new Org");

		// verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadermsg().getText();
		Assert.assertTrue(actOrgName.contains(orgName));
	}

	
	@Test(groups = "RegressionTest")
	public void createOrgWithIndustryTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		// read testScript data from excelFile
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		// Step 2 : navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4 : enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type);
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===>Create a new Org"  + industry +"===>Create a new Industry"   + type +"===>Create a new type");

		// Verify Industry and Type information
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustry = oip.getIndustryInfo().getText();
		Assert.assertEquals(actIndustry, industry);
		
		String actType = oip.getTypeInfo().getText();
		Assert.assertEquals(actType, type);
	}
	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneNumberTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		
		// read testScript data from excelFile
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("org", 7, 3);

		// Step 2 : navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org Page");
		
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4 : enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNumber);
		
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===>Create a new Org"   + phoneNumber +"===>Create a new PhoneNumber");

		// verify Header phoneNumber info Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNumber = oip.getPhoneInfo().getText();
		Assert.assertEquals(actPhoneNumber, phoneNumber);
	}
	
}

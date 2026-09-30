package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ActivateSimTest extends BaseClass {
	 
	@Test(enabled = false,retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("ActivateSim start");
		  System.out.println("Step-1");
		  String actTitle = driver.getTitle();
		  Assert.assertEquals(actTitle,"Home");
		  System.out.println("Step-2");
		  System.out.println("Step-3");
		  System.out.println("Step-4");
	}

}

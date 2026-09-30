package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;


public class InvoiceTest extends BaseClass{
	
	@Test(enabled = false)
	public void createInvoiceTest() {
		System.out.println("Executed createInvoiceTest");
		  String actTitle = driver.getTitle();
		  Assert.assertEquals(actTitle, "Home");
          System.out.println("Step-1");
		  System.out.println("Step-2");
		  System.out.println("Step-3");
		  System.out.println("Step-4");
	}
	
	@Test(enabled = false)
	public void createInvoicewithContactTest() {
		System.out.println("Executed createInvoicewithContactTest");
		 System.out.println("Step-1");
		 System.out.println("Step-2");
		 System.out.println("Step-3");
		 System.out.println("Step-4");
	}
}

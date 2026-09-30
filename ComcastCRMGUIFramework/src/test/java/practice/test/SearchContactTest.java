package practice.test;
/**
 * test class for Contact Module
 * @author SaiBhanuprakash
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass{ 

	/**
	 * Scenario: login() ==> navigateContact ==> createcontact() ==> verify
	 */
	
	@Test(enabled = false)
	public void searchcontactTest() {
		/*step1 login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "password");		
	}
}

package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoAmazontest {
	
	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName, String productName) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		// search product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		// capture product info
		String x = "//span[contains(text(),'"+productName+"')]/ancestor::div[@class='puisg-col-inner']//span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	 @DataProvider
	 public Object[][] getData() throws Throwable {
		 ExcelUtility elib = new ExcelUtility();
		 int rowCount = elib.getRowcount("product");
		 

		 Object[][] obj = new Object[rowCount][2];
		 
		 for(int i = 0; i < rowCount; i++) { 
			 obj[i][0] = elib.getDataFromExcel("product", i+1, 0);
			 obj[i][1]=  elib.getDataFromExcel("product", i+1, 1);
		 }
		 
		 return obj;
	 }

}

package learning.framework.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import learning.framework.pageObjects.AddCustomer;
import learning.framework.pageObjects.LoginPage;

public class Tc_AddCust_003 extends BaseClass {

	@Test
	public void addCustomer() throws IOException, InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUsrNm(userName);
		lp.setPassword(password);
		lp.setLogin();

		Thread.sleep(3000);
		AddCustomer addCust = new AddCustomer(driver);
		addCust.setNewCustLink();
		
		
		addCust.setReset();
		addCust.setCustNm("sagar");
		addCust.setGender();
		addCust.setDate("22", "09", "1998");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addCust.setAddress("ppm");
		addCust.setCity("Vixag");
		addCust.setState("Ap");
		addCust.setPin(123456);
		addCust.setPhNo(123456789);
		addCust.setEmail("abcd@gmail.com");
		addCust.setPwd("oiuyt");
		addCust.setSubmit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Assert.assertTrue(false);

		/*if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Added customer successfully");
		} else  {
			captureScreen(driver, "AddCustomer");
			String alrtMsg = driver.switchTo().alert().getText();
			System.out.println(alrtMsg);
			logger.info(alrtMsg);
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);

		}*/

	}

}

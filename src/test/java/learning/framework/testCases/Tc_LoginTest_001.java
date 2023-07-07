package learning.framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import learning.framework.pageObjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

        logger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsrNm(userName);
		lp.setPassword(password);
		lp.setLogin();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage1")) {
			Assert.assertTrue(true);
			logger.info("Title matched");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Title not matched");
		}
	}

}

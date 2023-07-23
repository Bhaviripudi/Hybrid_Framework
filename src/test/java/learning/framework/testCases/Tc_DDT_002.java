package learning.framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import learning.framework.pageObjects.LoginPage;
import learning.framework.utilities.XLUtils;

public class Tc_DDT_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUsrNm(user);
		lp.setPassword(pwd);
		lp.setLogin();

		if (isAlertPresent() == true) {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		} else {

			Assert.assertTrue(true);
			Thread.sleep(3000);
			logger.warn("login successful");
			lp.setLogOut();
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}

	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir")
				+ "\\src\\test\\java\\learning\\framework\\testData\\LoginData.xlsx";

		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rowCount][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// in two dimensional array row always starts from 0 but in excel we have eliminated 1st row.
				
			}
		}
		return loginData;
	}
}

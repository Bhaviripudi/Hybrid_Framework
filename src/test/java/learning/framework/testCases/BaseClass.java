package learning.framework.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import learning.framework.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String url = readConfig.getApplUrl();
	public String userName = readConfig.getUsrNm();
	public String password = readConfig.getPwd();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			// + "\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDr());
			driver = new ChromeDriver();
			
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDr());
			driver = new FirefoxDriver();
			System.out.println(driver.manage().window().getSize());
			driver.manage().window().setSize(new Dimension(1400,1000));
			System.out.println(driver.manage().window().getSize());
		}

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String shtname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + shtname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return false;
		}
	}
	
//	public String randomString() {
//	String generaterStr = RandomStringUtils.randomAlphabetic(8);
//	return generateStr;
//}

}

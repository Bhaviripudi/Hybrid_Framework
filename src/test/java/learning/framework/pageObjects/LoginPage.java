package learning.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver dr){
		driver = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logOut;
	
	
	public void setUsrNm(String usrNm) {
		userName.sendKeys(usrNm);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setLogin() {
		login.click();
	}
	
	public void setLogOut() {
		logOut.click();
	}
	
}

package learning.framework.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer {

	WebDriver driver;
	 
	public AddCustomer(WebDriver dr) {
		
		driver = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newCustomerLnk;
	
	@FindBy(name="res")
	WebElement reset;
	
	@FindBy(name="name")
	WebElement custName;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement date;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobileNo;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public void setNewCustLink() {
		
		newCustomerLnk.click();
	}
	
	public void setReset() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(reset));
		reset.click();
	}
	
	public void setCustNm(String custNM) {
		custName.sendKeys(custNM);
	}
	
	public void setGender() {
		if(gender.isSelected()==false) 
		gender.click();
		
	}
	
	public void setDate(String dd, String mm, String yyyy) {
		date.sendKeys(dd);
		date.sendKeys(mm);
		date.sendKeys(yyyy);
	}
	
	public void setAddress(String addr) {
		address.sendKeys(addr);
	}
	
	public void setCity(String cty) {
		city.sendKeys(cty);
	}
	
	public void setState(String stt) {
		state.sendKeys(stt);
	}
	
	public void setPin(int pinNo) {
		pin.sendKeys(String.valueOf(pinNo));
	}
	public void setPhNo(int phNo) {
		mobileNo.sendKeys(String.valueOf(phNo));
	}
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setSubmit() {
		submit.click();
	}
}

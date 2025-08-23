package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Locator
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	//Actions
	public void entermail(String mail) {
		txtemail.sendKeys(mail);
	}
	
	public void enterpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
	
}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

	// Constructor
	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirm;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement radionewsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirm;
	
	//Actions
	public void enterfirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void entermail(String mail) {
		txtemail.sendKeys(mail);
	}
	
	public void enterphone(String num) {
		txtphone.sendKeys(num);
	}
	
	public void enterpass(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void confirmpass(String cpass) {
		txtconfirm.sendKeys(cpass);
	}
	
	public void clickradio() {
		radionewsletter.click();
	}
	
	public void clickpolicy() {
		chkpolicy.click();
	}
	
	public void clickcontinue() {
		btncontinue.click();
	}
	
	public String msg() {
		try {
			return(msgconfirm.getText());
		}
		catch(Exception e){
			return e.getMessage();
	}
}
}
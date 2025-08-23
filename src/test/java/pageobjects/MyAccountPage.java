package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement header;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnklogout;
	
	public void clicklogout() {
		lnklogout.click();
	}
	
	public boolean msgvalidation() {
		try {
		return (header.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
	}
}

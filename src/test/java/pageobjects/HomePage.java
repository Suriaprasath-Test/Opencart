package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Locator
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch;
	
	@FindBy(xpath="//a[normalize-space()='Site Map']")
	WebElement lnksitemap;
	
	//Actions
	public void clickmyaccount() {
		lnkMyAccount.click();
	}
	
	public void clickregister() {
		lnkRegister.click();
	}
	
	public void clicklogin() {
		lnklogin.click();
	}
	
	public void clicksitemap() {
		lnksitemap.click();
	}
	
	public void txtsearch(String item) {
		txtsearch.sendKeys(item);
	}
	
	public void clearsearch() {
		txtsearch.clear();
	}
	
	public boolean issearchboxdisplayed() {
		return txtsearch.isDisplayed();
	}
	
}

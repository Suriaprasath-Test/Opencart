package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends BasePage{

	public SiteMapPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Search']")
	WebElement lnksearch;
	
	public void clicksearch() {
		lnksearch.click();
	}
}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage{

	public ProductComparisonPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Product Comparison']")
	WebElement prodocutcomptext;
	
	@FindBy(xpath="//div[@class='col-sm-4']//button[2]")
	WebElement btncompare;
	
	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement lnkcomparelist;
	
	public boolean distxt() {
		boolean val=prodocutcomptext.isDisplayed();
		return val;
	}
	
	public void clickcompare() {
		btncompare.click();
	}
	
	public void clicklinklist() {
		lnkcomparelist.click();
	}
}

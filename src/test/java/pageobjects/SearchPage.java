package pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='image']")
	WebElement image;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement text;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement icnsearch;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement category;
	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement searchbox;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement btnsearch;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement fldselect;
	
	@FindBy(xpath="//select[@name='category_id']/option[text()='Laptops & Notebooks']")
	WebElement fldoption;
	
	@FindBy(xpath="//select[@name='category_id']/option[text()='Tablets']")
	WebElement fldoption2;
	
	@FindBy(xpath="//input[@name='sub_category']")
	WebElement chksubcategory;
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement productimg;
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	WebElement homeicon;
	
	@FindBy(xpath="//i[@class='fa fa-th']")
	WebElement gridicon;
	
	@FindBy(xpath="//a[@id='compare-total']")
	WebElement lnkproduct;
	
	@FindBy(xpath="//ul[@class='breadcrumb']")
	WebElement breadcrumb;
	
	public List<WebElement> sort=driver.findElements(By.xpath("//select[@id='input-sort']"));
	
	public boolean disimage() {
		return image.isDisplayed();
	}
	
	public boolean distext() {
		try {
	        WebElement txt = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"));
	        return txt.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;  // element not present = no error text
	    }
	}
	
	public void icnsearch() {
		icnsearch.click();
	}
	
	public void clsearch() {
		icnsearch.clear();
	}
	
	public void dropclick() {
		category.click();
	}
	
	public void clicksearch() {
		btnsearch.click();
	}
	
	public void searchtext(String item) {
		searchbox.sendKeys(item);
	}
	
	public void clickselect() {
		fldselect.click();
	}
	
	public void clickoption() {
		fldoption.click();
	}
	
	public void clickoption2() {
		fldoption2.click();
	}
	
	public void checkbox() {
		chksubcategory.click();
	}
	
	public void clickproduct() {
		productimg.click();
	}
	
	public void clickhome() {
		homeicon.click();
	}
	
	public void clickgrid() {
		gridicon.click();
	}
	
	public void clickproductlink() {
		lnkproduct.click();
	}
	
	public List <WebElement> clicksort() {
		return sort;
	}
	

	public boolean issearchbuttondisplayed() {
		return icnsearch.isDisplayed();
	}
	
	public boolean isgridicondisplayed() {
		return gridicon.isDisplayed();
	}
	
	public boolean isbreaddisplayed() {
		return breadcrumb.isDisplayed();
	}
}

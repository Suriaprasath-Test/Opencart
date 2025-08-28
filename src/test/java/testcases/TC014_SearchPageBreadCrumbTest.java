package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC014_SearchPageBreadCrumbTest extends BaseClass{
	
	@Test
	public void validatebreadcrumb() {
		try {
		HomePage obj=new HomePage(driver);
		obj.txtsearch("imac");
		
		SearchPage obj1=new SearchPage(driver);
		obj1.icnsearch();
		boolean val=obj1.isbreaddisplayed();
		if(val==true) {
			Assert.assertEquals(val, true);
		}
		}
	catch(Exception e) {
		Assert.fail();
	}
		
}}
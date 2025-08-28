package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import pageobjects.SiteMapPage;
import testbase.BaseClass;

public class TC013_SearchPageFromSiteMap extends BaseClass{
	@Test
	public void sitemaptosearch() {
		HomePage obj=new HomePage(driver);
		obj.clicksitemap();
		
		SiteMapPage obj2=new SiteMapPage(driver);
		obj2.clicksearch();
		
		SearchPage obj3=new SearchPage(driver);
		boolean icon=obj3.distext();
		if(icon==true) {
			Assert.assertEquals(icon, true);
		}
	}
}

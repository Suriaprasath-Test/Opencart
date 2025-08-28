package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductComparisonPage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC015_ProductComparisonAddingTest extends BaseClass{
	 @Test
		public void validateproductcompareaddition() {
			 try {
			 	HomePage obj=new HomePage(driver);
				obj.txtsearch("mac");
				
				SearchPage obj2=new SearchPage(driver);
				obj2.icnsearch();
				obj2.clickproduct();
				
				ProductComparisonPage obj3=new ProductComparisonPage(driver);
				obj3.clickcompare();
				obj3.clicklinklist();
				boolean txt=obj3.distxt();
				if(txt==true) {
					Assert.assertEquals(txt, true);
				}
			 }
			 catch(Exception e) {
				 Assert.fail();
			 }
		}
}

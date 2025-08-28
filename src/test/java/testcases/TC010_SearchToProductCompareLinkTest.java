package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductComparisonPage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC010_SearchToProductCompareLinkTest extends BaseClass{
		 @Test
		public void validateproductcomparelink() {
			 try {
			 	HomePage obj=new HomePage(driver);
				obj.txtsearch("imac");
				
				SearchPage obj2=new SearchPage(driver);
				obj2.icnsearch();
				obj2.clickproductlink();
				
				ProductComparisonPage obj3=new ProductComparisonPage(driver);
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


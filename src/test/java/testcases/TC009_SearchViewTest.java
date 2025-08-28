package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC009_SearchViewTest extends BaseClass{
		@Test
		public void validateview() {
			try {
			HomePage obj=new HomePage(driver);
			obj.txtsearch("imac");
			
			SearchPage obj1=new SearchPage(driver);
			obj1.icnsearch();
			obj1.clickproduct();
			
			ProductPage obj2=new ProductPage(driver);
			boolean btn=obj2.discartbutton();
			if(btn==true) {
				Assert.assertEquals(btn, true);
			}
			obj1.clickhome();
			
			obj.txtsearch("imac");
			obj1.icnsearch();
			obj1.clickgrid();
			obj1.clickproduct();
			if(btn==true) {
				Assert.assertEquals(btn, true);
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
}
}
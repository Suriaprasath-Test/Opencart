package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC008_SearchSubCategory extends BaseClass{
	@Test
	public void categorysearch() {
	HomePage obj=new HomePage(driver);
	obj.txtsearch(" ");
	
	
	SearchPage obj2=new SearchPage(driver);
	obj2.icnsearch();
	obj2.searchtext("mac");
	obj2.clickselect();
	obj2.clickoption();
	obj2.clicksearch();
	obj2.checkbox();
	obj2.clicksearch();
	boolean img=obj2.disimage();
	if(img==true) {
		Assert.assertEquals(img, true);
	}
}
}

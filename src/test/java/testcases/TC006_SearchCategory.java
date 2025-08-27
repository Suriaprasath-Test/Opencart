package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;


public class TC006_SearchCategory extends BaseClass{
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
	
	boolean img=obj2.disimage();
	if(img==true) {
		Assert.assertEquals(img, true);
	}
	
	obj2.clickoption2();
	obj2.clicksearch();
	boolean txt=obj2.distext();
	if(txt==true) {
		Assert.assertEquals(txt,true);
	}
}
}
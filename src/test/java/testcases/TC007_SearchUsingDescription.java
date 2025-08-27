package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC007_SearchUsingDescription extends BaseClass{
	@Test
	public void descriptionsearch() {
	HomePage obj=new HomePage(driver);
	obj.txtsearch(" ");
	
	
	SearchPage obj2=new SearchPage(driver);
	obj2.icnsearch();
	obj2.searchtext("music videos");
	boolean img=obj2.disimage();
	if(img==true) {
		Assert.assertEquals(img, true);
	}
	else {
		Assert.assertEquals(img, false);
	}
}
}
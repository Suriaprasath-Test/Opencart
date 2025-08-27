package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC005_SearchAfterlogin extends BaseClass{
	
	@Test
	public void loginsearch() {
		try {
			logger.info("------Test sterted-------");
		HomePage obj=new HomePage(driver);
		obj.clickmyaccount();
		obj.clicklogin();
		
		LoginPage obj2=new LoginPage(driver);
		obj2.entermail(p.getProperty("email"));
		obj2.enterpassword(p.getProperty("password"));
		obj2.clicklogin();
		
		obj.txtsearch("Mac");
		SearchPage obj3=new SearchPage(driver);
		obj3.icnsearch();
		boolean img=obj3.disimage();
		logger.info("------Validation sterted-------");
		if(img==true) {
			Assert.assertEquals(img, true);
		}
		else {
			Assert.assertEquals(img, null);
		}}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("------Test finished-------");
	}
}

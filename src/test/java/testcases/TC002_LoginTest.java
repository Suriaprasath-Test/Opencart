package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups= {"master","sanity"})
	public void validatinglogin() {
		try {
		logger.info("----TC_002 STARTS----");
		HomePage homeobj=new HomePage(driver);
		logger.info("----Opens homepage----");
		homeobj.clickmyaccount();
		homeobj.clicklogin();
		
		LoginPage loginobj=new LoginPage(driver);
		logger.info("----Opens Login page and Enter details----");
		loginobj.entermail(p.getProperty("email"));
		loginobj.enterpassword(p.getProperty("password"));
		loginobj.clicklogin();
		
		MyAccountPage accobj=new MyAccountPage(driver);
		logger.info("----Validation takes place----");
		boolean msg=accobj.msgvalidation();
		Assert.assertEquals(msg, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("----TC_002 Finished----");
	}
}

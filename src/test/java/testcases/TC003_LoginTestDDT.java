package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass{
	
	@Test(groups= {"master"},dataProvider="dp",dataProviderClass=DataProviders.class)
	public void datadrivenlogintest(String mail,String pwd, String res) {
		try {
			logger.info("----TC_003 STARTS----");
			HomePage homeobj=new HomePage(driver);
			logger.info("----Opens homepage----");
			homeobj.clickmyaccount();
			homeobj.clicklogin();
			
			LoginPage loginobj=new LoginPage(driver);
			logger.info("----Opens Login page and Enter details----");
			loginobj.entermail(mail);
			loginobj.enterpassword(pwd);
			loginobj.clicklogin();
			
			MyAccountPage accobj=new MyAccountPage(driver);
			logger.info("----Validation takes place----");
			boolean msg=accobj.msgvalidation();
			
			/*
			 * Data valid ---login success --- test pass --- logout 
			 * 			  --- login failed---- test fail
			 * 
			 * Data invalid--- login success--test fail--logout
			 * 				-- login failed---test pass
			 * */
			
			if(res.equalsIgnoreCase("valid")) {
				if(msg==true) {
					Assert.assertEquals(true, true);
					homeobj.clickmyaccount();
					accobj.clicklogout();
				}
				else {
					
					Assert.assertEquals(false, true);
				}
			}
			
			if(res.equalsIgnoreCase("invalid")) {
				if(msg==true) {
					accobj.clicklogout();
					Assert.assertEquals(false, true);
				}
				else {
					Assert.assertEquals(false, false);
				}
			}
			}
		catch(Exception e) {
			Assert.fail();
		}
			logger.info("***TC_003 Finished***");
	}
}

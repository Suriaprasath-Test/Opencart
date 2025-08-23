package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.RegisterAccountPage;
import testbase.BaseClass;

public class TC001_RegisterAccountTest extends BaseClass{
	
	@Test(groups= {"master","regression"})
	public void RegisterAccountValidation() throws InterruptedException {
		logger.info("TC001...");
		try {
		logger.info("Test started...");
		HomePage homeobj=new HomePage(driver);
		logger.info("Clicking my account..");
		homeobj.clickmyaccount();
		logger.info("Clicking resgister...");
		homeobj.clickregister();
		
		RegisterAccountPage registerobj =new RegisterAccountPage(driver);
		logger.info("Entering details...");
		registerobj.enterfirstname(randomstring());
		registerobj.enterlastname(randomstring());
		registerobj.entermail(randommail()+"gmail.com");
		registerobj.enterphone(randomnumber());
		
		String pass =randomstring();
		registerobj.enterpass(pass);
		registerobj.confirmpass(pass);
		
		registerobj.clickradio();
		registerobj.clickpolicy();
		registerobj.clickcontinue();
		
		String message=registerobj.msg();
		Assert.assertEquals(message, "Your Account Has Been Created!");
		logger.info("Test passed...");
		}
		catch(Exception e){
			logger.info("Test...");
			logger.debug("Debug logs...");
			Assert.assertEquals(false,true);
		}
	}
	
	
}
